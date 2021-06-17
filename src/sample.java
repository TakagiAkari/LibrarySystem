    import java.text.SimpleDateFormat;
import java.util.Calendar;

    public class sample {

        public static void main(String[] args) {
            Calendar cl = Calendar.getInstance();

            // SimpleDateFormatクラスを使用して、パターンを設定する
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
            System.out.println(sdf.format(cl.getTime()));
        }

    }

