package data_structure;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class map {

	public static void main(String[] args) {
//		Map<Integer,String> map = new TreeMap<>();
//		map.put(4,"Z");
//		map.put(3,"U");
//		map.put(2,"F");
//		map.put(4,"B");
//		map.put(1,"A");
		
		/* output
		 * 	1 A
			2 F
			3 U
			4 B
		 */
		
//		Map<Integer,String> map = new HashMap<>();
//		map.put(1,"A");
//		map.put(4,"Z");
//		map.put(3,"U");
//		map.put(2,"F");
//		map.put(4,"H");
//		map.put(1,"I");
		/*   	1 I
				2 F
				3 U
				4 H  */
		
		Map<Integer,String> map = new LinkedHashMap<>();
		map.put(1,"A");
		map.put(4,"Z");
		map.put(3,"U");
		map.put(2,"F");
		map.put(4,"H");
		map.put(1,"I");
		/*
		1 I
		4 H
		3 U
		2 F
		*/
		Set<Integer> key = map.keySet();
		for(Integer k : key) {
			System.out.println(k +" "+map.get(k) );
		}
	}
		
}
