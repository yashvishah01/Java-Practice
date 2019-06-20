package com;


class Res1{
	public synchronized void method1(Res2 r2){
		System.out.println("Method 1 start of res1");
		System.out.println("res1 wants res2 method1");
		r2.method1(this);
		System.out.println("Method 1 end of res1");
	}
	public synchronized void method2(){
		System.out.println("Method 2 start of res1");
		
		System.out.println("Method 2 end of res1");
	}
}

class Res2{
	public synchronized void method1(Res1 r1){
		System.out.println("Method 1 start of res2");
		System.out.println("res2 wants res1 method1");
		r1.method1(this);
		System.out.println("Method 1 end of res2");
	}
	public synchronized void method2(){
		System.out.println("Method 2 start of res2");
		
		System.out.println("Method 2 end of res2");
	}
}

public class Deadlock_ex {
	
	public static void main(String [] args) {
		Res1 r1= new Res1();
		Res2 r2= new Res2();
		
		Runnable task1 = ()->{
			r1.method1(r2);
		};
		
		Runnable task2 = ()->{
			r2.method1(r1);
		};
		
		Thread thread1 = new Thread(task1);
		Thread thread2 = new Thread(task2);
		
		thread1.start();
		thread2.start();
	}
	
}
