import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
 
public class DateTimeExamples {
 
	public static void main(String[] args) {
                Date date=new Date(114,2,18);
                System.out.println("Note the time includes the default timezone - " + date.toString());
                LocalDate date1=LocalDate.of(2014,3,18);
             	System.out.println("date - " + date1.toString());
                int year=date1.getYear();
 		System.out.println("year - " + year);
    		Month month=date1.getMonth();
		System.out.println("month - " + month.toString());
		DayOfWeek day=date1.getDayOfWeek();
		System.out.println("day - " + day.toString());
		int len=date1.lengthOfMonth();
		System.out.println("len- " + len);
		boolean leap=date1.isLeapYear();
		System.out.println("leap - " + leap);
                LocalTime time=LocalTime.of(13,45,20);
		int hour=time.getHour();
		System.out.println("hour " + hour);
                int minute=time.getMinute();
		System.out.println("Minute- " + minute);
		int second=time.getSecond();
		System.out.println("Second " + second);
	}
 
	

}
