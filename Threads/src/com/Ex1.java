package com;

public class Ex1 {
		// it can be inside main method
		static Runnable task = () ->{
			String name = Thread.currentThread().getName();
			//System.out.println(name);
			System.out.println("runnable start");
			
			for(int i=0;i<5000;i++) {
				System.out.println(name + " "+i);
			}
			
		};
		
		public static void main(String args[]) {
			Thread thread2 = new Thread(task);
			Runnable task1 = () ->{
				String name = Thread.currentThread().getName();
				System.out.println(name);
				System.out.println("runnable start inside main");
				thread2.start();
				try {
					thread2.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("runnable end inside main"); 
			};
			
			Thread thread = new Thread(task1);
			thread.start();
		}
}
