package com.zking.p2pSSM.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *	时间转换
 * @param date
 * @return
 */
public class DateUtil {
	public static Date strchangedate(String date) {
		try {
			if (date.length() < 12) {
				date = date + " 00:00:00";
			}
			SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return sim.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
