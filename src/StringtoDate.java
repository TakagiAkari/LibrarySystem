import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringtoDate {
    public static void main(String[] args) throws ParseException {
    	Date date1 = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        DateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd");
        Date date = dateFormat.parse(dateFormat1.format(date1));
        
        System.out.println( date );

    }
}