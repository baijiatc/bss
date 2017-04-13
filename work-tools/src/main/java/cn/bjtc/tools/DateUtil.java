package cn.bjtc.tools;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 日期转换工具类，默认日期格式：yyyy-MM-dd HH:mm:ss
 * @author fishcer
 *
 */
public class DateUtil {
	private static Log logger = LogFactory.getLog(DateUtil.class);
	private static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
	private static SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_FORMAT);
	
	public static String systemCurrentDateStr(){
		return systemCurrentDateStr(DEFAULT_FORMAT);
	}
	
	public static String systemCurrentDateStr(String pattern){
		Calendar calendar = Calendar.getInstance();
		sdf.applyPattern(pattern);
		return sdf.format(calendar.getTime()); 
	}
	
	public static Date systemCurrentDate(){
		Calendar calendar = Calendar.getInstance();
		return calendar.getTime();
	}
	
	public static Long systemCurrentDateInMillis(){
		Calendar calendar = Calendar.getInstance();
		return calendar.getTimeInMillis();
	}
	
	public static String convertDateToStr(Date date){
		return convertDateToStr(date,DEFAULT_FORMAT);
	}
	
	public static String convertDateToStr(Date date, String pattern){
		sdf.applyPattern(pattern);
		return sdf.format(date);
	}
	
	public static Date convertStrToDate(String dateStr){
		return convertStrToDate(dateStr,DEFAULT_FORMAT);
	}
	
	public static Date convertStrToDate(String dateStr,String pattern){
		sdf.applyPattern(pattern);
		try {
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			logger.info("Throws exception when convert string to date." + e.getMessage());
		}
		return null;
	}
	
	/**
	 * 
	 * @param field the calendar field.
	 * @param amount the amount of date or time to be added to the field.
	 * @param dateStr
	 * @param pattern
	 * @return
	 */
	public static Date dateAdd(int field,int amount,String dateStr, String pattern){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(convertStrToDate(dateStr, pattern));
		calendar.add(field, amount);
		return calendar.getTime();
	}
	
	public static Date dateAdd(int field,int amount,Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(field, amount);
		return calendar.getTime();
	}
	
	public static int datePart(int field,Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(field);
	}
	
	/**
	 * 当月第一天
	 * @return
	 */
	public static Date frstDayOfCurrentMonth(){
		Calendar calendar = Calendar.getInstance();
		int amount = calendar.get(Calendar.DAY_OF_MONTH);
		Date frstDay = dateAdd(Calendar.DAY_OF_MONTH,(1-amount),systemCurrentDateStr(),"yyyy-MM-dd");
		return frstDay;
	}
	
	public static String frstDayStrOfCurrentMonth(){
		return convertDateToStr(frstDayOfCurrentMonth());
	}
	
	/**
	 * 下月第一天
	 * @return
	 */
	public static Date frstDayOfNextMonth(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(frstDayOfCurrentMonth());
		calendar.add(Calendar.MONTH, 1);
		return calendar.getTime();
	}
	
	public static String frstDayStrOfNextMonth(){
		return convertDateToStr(frstDayOfNextMonth());
	}
	
	public static Timestamp systemCurrentTimestamp(){
		return new Timestamp(systemCurrentDateInMillis());
	}
	/**
	 * 获取当年第一天
	 * @return
	 */
	public static Date getCurrYearFirst(){  
        Calendar currCal=Calendar.getInstance();    
        int currentYear = currCal.get(Calendar.YEAR);  
        return getYearFirst(currentYear);  
    }
	public static Date getYearFirst(int year){  
        Calendar calendar = Calendar.getInstance();  
        calendar.clear();  
        calendar.set(Calendar.YEAR, year);  
        Date currYearFirst = calendar.getTime();  
        return currYearFirst;  
    }

}
