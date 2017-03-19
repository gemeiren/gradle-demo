package javaBase.util.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: 测试超时时间  Date函数
 * @date 2016年7月15日 上午9:34:07
 */
public class testExpiredTime {
	public static void main(String[] args) {
		
		String dateFormat="yyyy-MM-dd HH:mm:ss";
		Date now =new Date();
		
		System.out.println("时间:" + convertDateToStr(theExpiredTime(now, 0),dateFormat));
		System.out.println("时间:" + convertDateToStr(theExpiredTime(now, 60),dateFormat));// 60秒
		
	}
	
	/**
	 * @Description: 将date减去多少分钟，时间提前到某个点
	 * @param currentTime
	 * @param minTime
	 * @return
	 */
	private static Date theExpiredTime(Date currentTime,
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
