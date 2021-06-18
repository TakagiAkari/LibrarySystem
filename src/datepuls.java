    import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
     
    public class datepuls {
    	public static void main(String[] args) {
     
    		//特定の日時を取得(String型)
    		LocalDateTime datetime = LocalDateTime.parse("2010/10/20 05:42:31",DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
     
    		//10日後を取得
    		LocalDateTime dateAdd10 = datetime.plusDays(10);
     
    		//結果を表示
    		System.out.println(dateAdd10);
    	}
    }