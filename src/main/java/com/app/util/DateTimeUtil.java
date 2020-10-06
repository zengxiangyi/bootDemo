package com.app.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeUtil {
	private static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	private static final String TIME_DEFAULT_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
	private static final String DATE_FORMAT = "yyyy-MM-dd";

	/**
	 * Date时间转字符串输出
	 */
	public static String DateToString(Date date) {
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(TIME_DEFAULT_FORMAT);
			return sdf.format(date);
		} else {
			return "";
		}
	}

	/**
	 * Date时间转字符串输出
	 */
	public static String dateToStr(Date date) {
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT);
			return sdf.format(date);
		} else {
			return "";
		}
	}

	/**
	 * 字符串转Date时间
	 */
	public static Date StringToDate(String date) {
		if (StringUtil.isRightValue(date)) {
			SimpleDateFormat sdf = new SimpleDateFormat(TIME_DEFAULT_FORMAT);
			try {
				return sdf.parse(date);
			} catch (ParseException ex) {
				ex.printStackTrace();
			}
		}
		return new Date();
	}

	/**
	 * Date时间转日期
	 */
	public static LocalDate date2LocalDate(Date date) {
		if (null == date) {
			return null;
		}
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	/**
	 * Date时间转 LocalDateTime
	 */
	public static LocalDateTime date2LocalDateTime(Date date) {
		if (null == date) {
			return null;
		}
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	/**
	 * localDateTime 转 Date
	 */
	public static Date localDateTime2Date(LocalDateTime localDate) {
		if (null == localDate) {
			return null;
		}
		ZonedDateTime zonedDateTime = localDate.atZone(ZoneId.systemDefault());
		return Date.from(zonedDateTime.toInstant());
	}

	public static String localDateTimeToString(LocalDateTime dateTime) {
		DateTimeFormatter df = DateTimeFormatter.ofPattern(TIME_FORMAT);
		String timestr = df.format(dateTime);
		return timestr;
	}

	public static LocalDate stringToLocalDate(String date) {
		return null;
	}

	public static String localDateToString() {
		return null;
	}

	public static LocalDateTime stringToLocalDateTime(String time) {
		DateTimeFormatter df = DateTimeFormatter.ofPattern(TIME_DEFAULT_FORMAT);
		LocalDateTime dateTime = LocalDateTime.parse(time, df);
		return dateTime;
	}

	public static int betweenDays(LocalDate start, LocalDate end) {
		if (start == null) {
			start = LocalDate.now();
		}
		if (end == null) {
			end = LocalDate.now();
		}
		long daysNum = end.toEpochDay() - start.toEpochDay();
		return (int) daysNum;
	}

	public static String currentTime() {
		return localDateTimeToString(LocalDateTime.now());
	}

}
