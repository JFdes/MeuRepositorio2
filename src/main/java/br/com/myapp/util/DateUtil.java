package br.com.myapp.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static Date getCurrent() {

		return Calendar.getInstance().getTime();
	}
}
