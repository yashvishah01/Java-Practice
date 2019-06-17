package com;
// import java.lang.annotation.*;

 import org.junit.Before;
 import org.junit.Test;
 import static org.junit.Assert.*;
 
public class ex1_used {
	
	ex1 e;
	@Before
	public void Setup(){
		System.out.println("@Before");
		ex1 e =new ex1();
	}
	
	@Test
	public void add() {
		int actual = e.add(12,12);
		int expected = 24;
		assertEquals(expected, actual);
	}
	
	@Test
	public void add2() {
		int actual = e.add(12, 12);
		int expected = 25;
		assertNotEquals(expected, actual);
	}

}
