import java.security.Timestamp;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class lazy {

	public static void main(String [] args) {
		String s1 ="hello";
		
		/** Eager function */
		//Objects.requireNonNull(s1, "s1 should not null"+ getmethod());
		
		/** Lazy function */
		Objects.requireNonNull(s1, ()->"s1 should not null"+ getmethod());
		System.out.print("all well");
				
	}

	private static String getmethod() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return LocalDateTime.now().toString();
	}
}
