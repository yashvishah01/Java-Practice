package data_structure;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

// set avoid duplicates

public class set {
	public static void main(String[] args) {
		//Set<String> set = new TreeSet<>((o1,o2)->o2.compareTo(o1)); // desc
		Set<String> set = new HashSet<>();
		//Set<String> set = new LinkedHashSet<>();
		set.add("A");
		set.add("B");
		set.add("Z");
		set.add("S");
		set.add("C");
		set.add("P");
		set.add("Y");
		set.add("A");
		set.add("Y");
		/*
		 * 	treeset ==>  	[Z, Y, S, P, C, B, A]	//give comparator
		 * 
		 * 	hashset ==> 	[P, A, B, S, C, Y, Z]	// not sorted, sorted according to hashvalue
		 * 
		 * Linkedhashset ==>	[A, B, Z, S, C, P, Y]
		 */
		System.out.println(set);
	}
}
