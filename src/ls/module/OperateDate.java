package ls.module;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import ls.bean.InputMemberBean;

public class OperateDate {

	public static Date getJavaSqlDateOfInputMemberBean(InputMemberBean memberInfo) throws ParseException {
		// SimpleDateFormatにミリ秒まで渡す形式のため、後半を0で埋めている
		String birthDay = memberInfo.getBirthY() + "/" + memberInfo.getBirthM() + "/" + memberInfo.getBirthD() + " 00:00:00.000";
		System.out.println(birthDay);

		SimpleDateFormat sdf  = new SimpleDateFormat("yyy/MM/dd HH:mm:ss.SSS");

		long millis;

		java.util.Date date = sdf.parse(birthDay);

		millis = date.getTime();
		return new Date(millis);
	}
	public static Date getDateNow() {
		// 現在時刻を取得
		long time =System.currentTimeMillis();
		// java.sql.Date
		return new Date(time);
}

}
