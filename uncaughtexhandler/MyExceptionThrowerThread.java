package com.kunal.practice.thread.completionservice.JavaBits.uncaughtexhandler;

public class MyExceptionThrowerThread implements Runnable {

	@Override
	public void run() {
		
//		Thread.currentThread().setUncaughtExceptionHandler(new UnCaughtExceptionHandler());
		
		int throwInDex = 10;
		
		for(int i =0;i< throwInDex;i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Index "+ i);
			if(i>5 && i%2==0) {
				System.out.println("Throwing exception for index "+ i);
				throw new RuntimeException();
			}
		}
		
	}

}
