import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Method_ref {

	public static boolean isnonveg(String s) {
		return s.equals("nveg");
	}

	private static void filter(List<String> list,Predicate<String> rn) {
		list.removeIf(rn);
		System.out.print(list);
	}
	
		public static void main(String [] args) {
			List<String> list = new ArrayList<>();
			list.add("veg");
			list.add("veg");
			list.add("nveg");
			list.add("nveg");
			list.add("nveg");
			list.add("veg");
			System.out.print(list);
			
			
//------------------------------------------------------------------------
			//using class
//------------------------------------------------------------------------
			class remove_non implements Predicate<String>{
				
				@Override
				public boolean test(String t) {
					return t.equals("nveg");
				}
				
			}
			Predicate<String> rn = new remove_non();
			Method_ref.filter(list,rn);
			
//------------------------------------------------------------------------
				//using anonymous class
//------------------------------------------------------------------------
			
			
//			Predicate<String> predicate = new Predicate<String>() {
//				@Override
//				public boolean test(String t) {
//					return t.equals("nveg");
//				}
//			};
//			list.removeIf(predicate);
//			System.out.print(list);

//------------------------------------------------------------------------
			//using functional programming and own function
//------------------------------------------------------------------------
			
			
//			Predicate<String> predicate2 = s->Method_ref.isnonveg(s);	
//			list.removeIf(predicate2);
//			//list.removeIf(s->Method_ref.isnonveg(s));
//			System.out.print(list);
			

//------------------------------------------------------------------------
				//using Method reference
//------------------------------------------------------------------------			

			
//			Predicate<String> predicate1 = Method_ref::isnonveg;
//			list.removeIf(predicate1);
//			System.out.print(list);
//			
			
			
			
		}

		

		
}
