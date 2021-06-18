package com.bishwajit.vikram.dateManipulation;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Bishwajit
 *
 */
public class DateFormatTimeStampConversion {

	public static final String PATTERN_1 = "dd-MM-yyyy";
	public static final String PATTERN_2 = "yyyy/MM/dd_hhmms";

	public static void main(String[] args) {
		displayPattern(PATTERN_1);
		displayPattern(PATTERN_2);
	}

	private static void displayPattern(String pattern) {
		String dateFormat = new SimpleDateFormat(pattern).format(new Date());
		System.out.println(dateFormat);
	}
}
