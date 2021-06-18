import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class sample2date {
    public static void main(String[] args) {
        Date date = new Date();
        DateFormat dateFormat1 = new SimpleDateFormat();
        //Date to String
        String strDate = dateFormat1.format(date);
        //Date to SQLDate


    }
}
