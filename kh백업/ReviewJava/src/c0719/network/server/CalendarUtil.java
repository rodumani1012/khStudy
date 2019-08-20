package c0719.network.server;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarUtil {

	public static String getDateTime() {
		GregorianCalendar c = new GregorianCalendar();

		int yearInt = c.get(Calendar.YEAR);
		int monthInt = c.get(Calendar.MONTH); // 컴퓨터상 월은 0~11 로 되어있음
		int dateInt = c.get(Calendar.DATE);
		int hourInt = c.get(Calendar.HOUR_OF_DAY);
		int minuteInt = c.get(Calendar.MINUTE);
		int secondInt = c.get(Calendar.SECOND);

		String year = String.valueOf(yearInt);
		String month = String.valueOf(monthInt + 1);
		if ((monthInt + 1) < 10) {
			month = "0" + (monthInt + 1);
		}
		String date = String.valueOf(dateInt);
		if (dateInt < 10) {
			date = "0" + dateInt;
		}
		String hour = String.valueOf(hourInt);
		if (hourInt < 10) {
			hour = "0" + hourInt;
		}
		String minute = String.valueOf(minuteInt);
		if (minuteInt < 10) {
			minute = "0" + minuteInt;
		}
		String second = String.valueOf(secondInt);
		if (secondInt < 10) {
			second = "0" + secondInt;
		}

		String result = year + "." + month + "." + date + " " + hour + ":" + minute + ":" + second;

		return result;
	}

	public static String getDate() {
		GregorianCalendar c = new GregorianCalendar();

		int yearInt = c.get(Calendar.YEAR);
		int monthInt = c.get(Calendar.MONTH); // 컴퓨터상 월은 0~11 로 되어있음
		int dateInt = c.get(Calendar.DATE);

		String year = String.valueOf(yearInt);
		String month = String.valueOf(monthInt + 1);
		if ((monthInt + 1) < 10) {
			month = "0" + (monthInt + 1);
		}
		String date = String.valueOf(dateInt);
		if (dateInt < 10) {
			date = "0" + dateInt;
		}
		String result = year + "." + month + "." + date;

		return result;
	}

}
