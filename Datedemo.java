import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
public class Datedemo
{
public static void main(String[] args) {
  // get current date and time
        LocalDateTime currTime = LocalDateTime.now();
        System.out.println("current date time: "+currTime);
	   LocalDate d1 = currTime.toLocalDate();
        System.out.println("current date: " + d1);
	 LocalTime t1 = currTime.toLocalTime();
        System.out.println("current time: " + t1);
}
}
