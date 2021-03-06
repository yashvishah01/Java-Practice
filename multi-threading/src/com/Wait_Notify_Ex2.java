package com;

import java.util.concurrent.TimeUnit;

class Pool {

	private Object lock = new Object();
	boolean b = false;

	public void swim() {
		String name = Thread.currentThread().getName();
		synchronized (lock) {
			if (b)
				try {
					//System.out.println(name + "lock wait");
					lock.wait(5);
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			b = true;
			System.out.println(name + " -- swimming started..");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + " -- swimming finished..");
			lock.notify();
			try {
				lock.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			b = false;
			
		}
	}

}

public class Wait_Notify_Ex2 {

	public static void main(String[] args) {

		Pool pool = new Pool();

		Runnable swimTask = () -> {
			for (int i = 0; i < 5; i++) {
				pool.swim();
			}
		};

		Thread thread1 = new Thread(swimTask, "boy");
		Thread thread2 = new Thread(swimTask, "girl");

			thread1.start();
			thread2.start();
			
		
		
		

	}

}