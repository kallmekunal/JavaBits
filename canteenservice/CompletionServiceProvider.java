package com.kunal.practice.thread.completionservice.canteenservice;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletionServiceProvider {
	private static ExecutorService executor = Executors.newCachedThreadPool();
	private static CompletionService service = new ExecutorCompletionService<>(executor);
	
	public static CompletionService getCompletionService() {
		return service;
	}

}
