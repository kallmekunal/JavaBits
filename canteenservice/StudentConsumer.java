package com.kunal.practice.thread.completionservice.JavaBits.canteenservice;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class StudentConsumer implements Runnable {
	private String studName;
	private CompletionService service;
	
	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public CompletionService getService() {
		return service;
	}

	public void setService(CompletionService service) {
		this.service = service;
	}

	public StudentConsumer(String studName, CompletionService service) {
		this.studName = studName;
		this.service = service;
	}

	@Override
	public void run() {
		System.out.println("Student waiting for food!");
        try {
			Future<FoodPlate> future = service.take();
			FoodPlate plate =future.get();
			System.out.println("Food is delivered by "+ plate.getFoodPlateCreatedBy());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
