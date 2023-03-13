package com.example.counter;

public class RaceConditionDemo {
	public static void main(String[] args) {
		
		// 멀티쓰레드 환경에서 하나의 객체를 공유하게 되면 뜻하지 않은 결과를 낼 수 있다.
		// 상태를 유지하게 설계하면 안됨 ( 싱글턴 )
		
		Counter counter = new Counter();
		Thread t1 = new Thread(counter, "Thread-1");
		Thread t2 = new Thread(counter, "Thread-2");
		Thread t3 = new Thread(counter, "Thread-3");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
