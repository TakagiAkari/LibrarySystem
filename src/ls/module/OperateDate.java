package ls.module;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import ls.bean.InputMemberBean;

public class OperateDate {

	static long ONE_DATE_MILLIS = 86400000;

	public static Date getJavaSqlDateOfInputMemberBean(InputMemberBean memberInfo) throws ParseException { // SimpleDateFormatにミリ秒まで渡す形式のため、後半を0で埋めている
		String birthDay = memberInfo.getBirthY() + "/" + memberInfo.getBirthM() + "/" + memberInfo.getBirthD() + " 00:00:00.000";
		System.out.println(birthDay);

		SimpleDateFormat sdf  = new SimpleDateFormat("yyy/MM/dd HH:mm:ss.SSS");

		long millis;

		java.util.Date date = sdf.parse(birthDay);

		millis = date.getTime();
		return new Date(millis);
	}

	public static Date getJavaSqlDateOfYMD(int year,int month, int day) throws ParseException { // SimpleDateFormatにミリ秒まで渡す形式のため、後半を0で埋めている
		String birthDay = year + "/" + month + "/" + day + " 00:00:00.000";
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

	public static Date plusDate(Date date,int days) {
		// Unix時刻にしてから計算する
		long millis = date.getTime();
		// 一日のミリ秒は86400000
		long afterDateMillis = millis + (days * ONE_DATE_MILLIS);
		return new Date(afterDateMillis);
	}

	public static int calcElapsedDay(Date beforeDate, Date afterDate) {

		long beforeDateMillis = beforeDate.getTime();
		long afterDateMillis = afterDate.getTime();

		long diffDateMillis = afterDateMillis - beforeDateMillis;

		return (int)(diffDateMillis / ONE_DATE_MILLIS);


	}
}
