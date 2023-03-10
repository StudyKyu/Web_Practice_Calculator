package com.example.oop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.HttpRequest;
import com.example.HttpResponse;
import com.example.QueryStrings;
import com.example.calculator.domain.Calculator;
import com.example.calculator.domain.PositiveNumber;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomWebApplicationServer {
    private final int port;
    
    private final ExecutorService executorsService = Executors.newFixedThreadPool(10);

    private static final Logger logger = LoggerFactory.getLogger(CustomWebApplicationServer.class);

    public CustomWebApplicationServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info("[CustomWebApplicationServer] started {} port.", port);

            Socket clientSocket;
            logger.info("[CustomWebApplicationServer] waiting for client.");

            while ((clientSocket = serverSocket.accept()) != null) {
                logger.info("[CustomWebApplicationServer] client connected!");
                
                // Thread Pool 적용, 안정적인 서비스 가능
                executorsService.execute(new ClientRequestHandler(clientSocket));
            }
        }
    }
}