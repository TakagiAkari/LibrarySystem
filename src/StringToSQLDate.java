    import java.sql.Date;

    public class StringToSQLDate {

        public static void main(String[] args) {
            Date sqlDate= Date.valueOf("2017-03-02");
            System.out.println("SQLのDate型 = " + sqlDate);
        }

    }