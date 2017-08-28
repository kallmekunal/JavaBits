package com.kunal.basic.concurrent.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import javax.print.attribute.standard.RequestingUserName;

public class ForkJoinTest  extends RecursiveTask<Integer>{

	private static int [] toSum ;
	private static int THRESHHOLD = 10;
	private  int start = 0;
	private  int end = 0;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ForkJoinTest(int arr[], int start,int end) {
		toSum = arr;
		this.start = start;
		this.end = end;
	}
	
	
	@Override
	protected Integer compute() {
		
		int datalength  = end - start;
		int sum=0;
		if(datalength > THRESHHOLD) {
			//Split the task
			ForkJoinTest leftTask = new ForkJoinTest(toSum, start, end-(datalength/2));
			ForkJoinTest rightTask = new ForkJoinTest(toSum, end-(datalength/2)+1, end);
			invokeAll(leftTask,rightTask);
			try {
				sum = (leftTask.get()+rightTask.get());
				System.out.println("Sum value "+ sum);
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("Threadid "+Thread.currentThread().getId());
			int value = 0;
			for(int i = start;i<=end;i++) {
			value = value + toSum[i];
			
			}
			System.out.println("Sum value "+ value);
			return value;
			
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int [] arr = new int[40];
		for(int i = 0;i<= 39;i++) {
			arr[i] = i+1;
		}
		ForkJoinTest test = new ForkJoinTest(arr, 0, 39);
		ForkJoinPool pool = new ForkJoinPool(4);
		pool.execute(test);
		try {
			System.out.println(test.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
