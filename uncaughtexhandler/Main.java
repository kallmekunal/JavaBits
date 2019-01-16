package com.kunal.practice.thread.completionservice.JavaBits.uncaughtexhandler;

public class Main {

	public static void main(String[] args) {
		Thread t1 = new Thread(new MyExceptionThrowerThread());
		Thread.setDefaultUncaughtExceptionHandler((th1,e1)-> {
			System.out.println("Defalut handler and not restarting");
			e1.printStackTrace();
		});
		t1.start();
	}

}
