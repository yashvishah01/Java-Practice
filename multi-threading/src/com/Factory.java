package com;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Factory {
	
	private static int []buffer;
	private static int count;
//	private static boolean evencheck = false;
	private static Object lock = new Object();
	static List<Integer> list = new ArrayList<>();
	
	static class EvenFactory{
		void Egenerate() {
			synchronized (lock) {
//			evencheck=true;
//			for(int i=2;i<100;i=i+2) {
//				while(!evencheck) {
//					try {
//						lock.wait();
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				};
//				buffer[count++] = i;
//				System.out.println(i);
//				try {
//					TimeUnit.SECONDS.sleep(2);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				evencheck=false;
//				lock.notifyAll();
//			}
				
				for(int i=2;i<100;i=i+2) {
					
					try {
						TimeUnit.MILLISECONDS.sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					list.add(i);
					System.out.println(i);
					lock.notify();
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
				}
			}
		}
	

	static class OddFactory{
		void Ogenerate() {
			synchronized (lock) {
//			for(int i=1;i<100;i=i+2) {
//				while(evencheck){
//					try {
//						lock.wait();
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				};
//				buffer[count++] = i;
//				System.out.println(i);
//				try {
//					TimeUnit.SECONDS.sleep(3);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				evencheck=true;
//				lock.notifyAll();
//			}
				
				for(int i=1;i<100;i=i+2) {
					try {
						TimeUnit.MILLISECONDS.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					list.add(i);
					System.out.println(i);
					
					lock.notify();
				try {
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		}
	}
	
	public static void main(String[] args) {
		buffer = new int[100];
		count = 0;
		
		EvenFactory evenFactory = new EvenFactory();
		OddFactory oddFactory = new OddFactory();
		
		Runnable even_task = () ->{
			evenFactory.Egenerate();
		};
		
		Runnable odd_task = () ->{
			oddFactory.Ogenerate();
		};
		
		Thread thread1 = new Thread(odd_task);
		Thread thread2 = new Thread(even_task);
		
		thread1.start();
		thread2.start();
		
		//System.out.println(list);
	}
}
}
