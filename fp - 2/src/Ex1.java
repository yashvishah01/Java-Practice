import java.util.function.Function;

public class Ex1 {

		public static void main(String[] args) {
			Function<String, Integer> function1 = s->{
				//System.out.println("before :: log");
				int i= Integer.parseInt(s);
				//System.out.println("after :: log");
				return i;
			};
			
			Function< Integer,String> function2 = i->{
				System.out.println("before :: log");
				String s =String.valueOf(i);
				System.out.println("after :: log");
				return s;
			};
			
			Function < Function<String, Integer> , Function<String, Integer>> logwrapper = infn->{
				return s->{
					System.out.println("before :: log");
					int r = infn.apply(s);
					System.out.println("after :: log");
					return r;
				};
			};
			
			Function<String, Integer> function1withlog = logwrapper.apply(function1);
			int r = function1withlog.apply("12345");
			System.out.println(r);
		}
}
