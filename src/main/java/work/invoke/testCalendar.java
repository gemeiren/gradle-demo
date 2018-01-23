package work.invoke;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;

/**
 * @Description : joda 简单使用
 * @Date: 2018年1月23日 下午10:48:12
 */
public class testCalendar {
	public static void main(String[] args) {
		//getCalendar();
		//getMinSettleDate();
		//getAutoAuditOrderPassTime();
	}



	private static void getCalendar() {
		Date currentDate = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		System.out.println("calendar.get(Calendar.MINUTE)=" + calendar.get(Calendar.MINUTE));
		
		calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) - Integer.valueOf("10"));
		String compareDate = df.format(calendar.getTime());
		
		System.out.println("calendar=" + (calendar.get(Calendar.MINUTE) - Integer.valueOf("10")));
		System.out.println("compareDate=" + compareDate);
	}
	
	private static String getAutoAuditOrderPassTime() {
		Integer diff = 20;
		DateTime now = DateTime.now();
		now = now.minusMinutes(diff);
		
		System.out.println("==== " + now.toString("yyyy-MM-dd HH:mm:ss"));
		return now.toString("yyyy-MM-dd HH:mm:ss");
	}
	
	private static String getMinSettleDate() {
		Integer diff = 10;
		DateTime now = DateTime.now();
		//System.out.println("now = " + now);
		
		now = now.minusMinutes(diff);
		
		System.out.println("==== " + now.toString("yyyy-MM-dd HH:mm:ss"));
		
		return now.toString("yyyy-MM-dd HH:mm:ss");
	}
	
}
