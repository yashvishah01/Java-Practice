package com.exception_handling;

class Bounce{
	private int fuel_no = 0;
	private boolean helmet = false;
	
	public int getFuel_no() {
		return fuel_no;
	}	
	public boolean getHemet() {
		return helmet;
	}
}
class CheckHel extends Exception {
	public CheckHel(String exception_msg){
		super(exception_msg);
	}
	
}

class Checkfuel extends Exception{
	private int fuel_no;
	
	public Checkfuel(int fuel_no) {
		super();
		this.fuel_no=fuel_no;
	}
	
	public String getMessage() {
		return " fuel is less around " + fuel_no;
	}
}
class User{
	
	public void book() throws CheckHel,Checkfuel{
		Bounce bike = new Bounce();
			int fuel_no=bike.getFuel_no();
			if(fuel_no<10) {
				throw new Checkfuel(fuel_no);
			}
			else {
				System.out.println("enough fuel");
			}
			
			boolean helmet = bike.getHemet();
			if(helmet) {
				System.out.println("has helmet");
			}
			else {
				throw new CheckHel("helmet not avail");
			}
	}
}

public class Use_Case {
	public static void main(String [] args) {
		User u1 = new User();
		try {
			u1.book();
		}catch(CheckHel c){
			System.out.println(c.getMessage());
		}catch(Checkfuel f){
			System.out.println(f.getMessage());
		}finally {
			System.out.println("End Trip");
		}
	}
}
