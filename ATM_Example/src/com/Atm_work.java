package com;


interface Chain 
{ 
    public abstract void setNext(Chain nextInChain); 
    public abstract void process(int amt); 
} 

class TwoThousand implements Chain{

		private Chain nextChain;
		private int avail=2;
		public void setNext(Chain c) {
			nextChain =c;
		}
		
		public void process(int amt) {
			int count=amt/2000;
			if(count>avail)		count =avail;
			if((count)!=0 && avail!=0) {
				amt = amt-(2000*count);
				System.out.println("2000 * " + count +" = "+2000*count);
				if(amt!=0)	nextChain.process(amt);
			}
			else
				nextChain.process(amt);
				
		}
}

class FiveHundred implements Chain{
	private Chain nextChain;
	private int avail=2;
	
	public void setNext(Chain c) {
		nextChain =c;
	}
	
	public void process(int amt) {
		int count=amt/500;
		if(count>avail)		count =avail;
		if((count)!=0 && avail!=0) {
			amt = amt-(500*count);
			System.out.println("500 * " + count +" = "+500*count);
			if(amt!=0)	nextChain.process(amt);
		}
		else
			nextChain.process(amt);
			
	}
}
class TwoHundred implements Chain{
	private Chain nextChain;
	private int avail=2;
	public void setNext(Chain c) {
		nextChain =c;
	}
	
	public void process(int amt) {
		int count=amt/200;
		if(count>avail)		count =avail;
		if((count)!=0 && avail!=0) {
			amt =amt-( 200*count);
			System.out.println("200 * " + count +" = "+200*count);
			if(amt!=0)	nextChain.process(amt);
		}
		else
			nextChain.process(amt);
			
	}
}
class Hundred implements Chain{
	private Chain nextChain;
	private int avail=15;
	
	public void setNext(Chain c) {
		nextChain =c;
	}
	
	public void process(int amt) {
		int count=amt-(amt/100);
		if(count>avail)		count =avail;
		if((count)!=0 && avail!=0) {
			amt = 100*count;
			System.out.println("100 * " + count +" = "+100*count);
			if(amt!=0)	System.out.println("not enough notes");
		}
		else
			nextChain.process(amt);
			
	}
}


public class Atm_work {
	public static void main(String args[]) {
		Chain c_2000 = new TwoThousand();
		Chain c_500 = new FiveHundred();
		Chain c_200 = new TwoHundred();
		Chain c_100 = new Hundred();
		
		c_2000.setNext(c_500);
		c_500.setNext(c_200);
		c_200.setNext(c_100);
		
		c_2000.process(3200);
	}
}
