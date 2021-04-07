/**
 * 
 */
package com.sid.java8.tutorials.Chapter16JavaAdvancedMultithreadingThreadTutorial.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Lenovo
 *
 */
public class LockWorkerWithSynchronizetion {
	private Random random = new Random();
	private List<Integer> list1 = new ArrayList<Integer>();
	private List<Integer> list2 = new ArrayList<Integer>();

	private synchronized void stageOne() throws InterruptedException {
		Thread.sleep(1);
		list1.add(random.nextInt(100));
	}

	private synchronized void stageTwo() throws InterruptedException {
		Thread.sleep(1);
		list2.add(random.nextInt(100));
	}

	private void process() throws InterruptedException {
		for (int i = 0; i < 1000; i++) {
			stageOne();
			stageTwo();
		}
	}

	public void main() throws InterruptedException {
		System.out.println("Starting...");
		long start = System.currentTimeMillis();
		Thread thread = new Thread(() -> {
			try {
				process();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		Thread thread2 = new Thread(() -> {
			try {
				process();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		thread.start();
		thread2.start();
		thread.join();
		thread2.join();
		long end = System.currentTimeMillis();
		System.out.println("Time taken to complete the task:" + (end - start));
		System.out.println("List 1 size:" + list1.size() + "; List 2 size:" + list2.size());
	}
}
