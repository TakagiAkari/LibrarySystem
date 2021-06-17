import java.text.SimpleDateFormat;
import java.util.Date;

public class DateToStringAndSQLDate {
    public static void main(String[] args) throws IllegalArgumentException {
        Date date = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //String
        String formattedDate = simpleDateFormat.format(date);
        //SQLDate
        java.sql.Date date1 = java.sql.Date.valueOf(formattedDate);

        System.out.println("SQL Date: " + date1);
        System.out.println("String:" + formattedDate);
    }
}

