package com.kunal.practice.thread.completionservice.JavaBits.canteenservice;

import java.util.concurrent.CompletionService;

public class Main {

	public static void main(String[] args) {
		CanteenStaffProducer prod1 = new CanteenStaffProducer("staff1");
		CanteenStaffProducer prod2 = new CanteenStaffProducer("staff2");
		CompletionService service = CompletionServiceProvider.getCompletionService();
		service.submit(prod1);
		service.submit(prod1);
		new Thread(new StudentConsumer("student1",service)).start();
		new Thread(new StudentConsumer("student2",service)).start();
	}

}
