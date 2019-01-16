package com.kunal.practice.thread.completionservice.JavaBits.uncaughtexhandler;

import java.lang.Thread.UncaughtExceptionHandler;

public class UnCaughtExceptionHandler implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("Caught Exception in UnCaughtExceptionHandler"+ e.getMessage());
		System.out.println("Starting new Thread");
		new Thread(new MyExceptionThrowerThread()).start();
	}

}
