package javaBase.util.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description: date函数、Calendar函数
 * @date 2016年9月22日 上午9:57:49
 */
public class testExpiredTimeV2 {
	public static void main(String[] args) throws Exception {
		
		long updateSecondTime = 1800;
		
		String dateStr = "2016-09-22 09:31:38";
		dateToSecondTime(updateSecondTime, dateStr);
		
		String dateStr1 = "2016-09-22 09:31:38";
		String dateStr2 = "2016-09-22 09:30:38";
		System.out.println("calLastedTime2 = " + calLastedTime2(dateStr1,dateStr2));
		
		System.out.println("calLastedTime = " + calLastedTime(dateStr));
		
		testCalendarDay();
		
		
		System.out.println("=--=-===========");
		testFinalTimeBefore();
		
		
	}
	
	public static void testFinalTimeBefore() throws Exception {
		Date now = new Date();
		Date finalTimeBefore = getMinTime(now, 10l);
		
		System.out.println("testFinalTimeBefore : " + convertDateToStr(finalTimeBefore, "yyyy-MM-dd HH:mm:ss"));
		
	}
	
	public static void testCalendarDay() throws Exception {
		 	Date currentDate = new Date();
	        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTime(currentDate);
	        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 16);
	        String minSettleDate = df.format(calendar.getTime());
	        System.out.println("minSettleDate: " + minSettleDate);
	}
	
	
	
	/**
	 * @Description 两个时间的时间差——秒差
	 * @date 2016年9月22日  上午10:15:15
	 */
	public static int calLastedTime2(String dateStr1, String dateStr2) {
		
		Date date1 = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date1 = df.parse(dateStr1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Date date2 = null;
		//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date2 = df.parse(dateStr2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		  long a = date1.getTime();
		  long b = date2.getTime();
		  int c = (int)((a - b) / 1000);
		  return c;
	}
	
	/**
	 * @Description 时间字符串与当前的秒数差
	 * @date 2016年9月22日  上午10:15:41
	 */
	public static  int calLastedTime(String dateStr) {
		
		Date date1 = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date1 = df.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		  long a = new Date().getTime();
		  long b = date1.getTime();
		  int c = (int)((a - b) / 1000);
		  return c;
	}


	/**
	 * @Description 计算出dateStr 的前updateSecondTime秒
	 * @date 2016年9月22日  上午10:07:42
	 */
	public static void dateToSecondTime(long updateSecondTime, String dateStr) {
		Date date = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date = df.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Date updateSecondTimeBefore2 = getMinTime(date, updateSecondTime);
		System.out.println("updateSecondTimeBefore2 : " + convertDateToStr(updateSecondTimeBefore2,"yyyy-MM-dd HH:mm:ss"));
	}
	
	
	/**
	 * @Description: 将date减去多少分钟，时间提前到某个点
	 * @Description 现在的前10分钟、默认10分钟
	 * @date 2016年8月8日  上午10:27:52
	 */
	private static Date getMinTime(Date currentTime,
			long minTime) {
		final int min = 60 * 72; // 默认72小时 自动取消
		if (minTime == 0) {
			return new Date(currentTime.getTime() - (1000l * 60 * min));
		} else {
			return new Date(currentTime.getTime() - (1000l * minTime));
		}
	}
	
	
	/**
	  * @Description: 将date时间转为string
	 * @param date
	 * @param dateFormat
	 * @return
	 */
	public static String convertDateToStr(Date date, String dateFormat)
	   {
	      if(date == null) {
	         return "";
	      }
	      SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
	      return sdf.format(date);
	   }
	
}
