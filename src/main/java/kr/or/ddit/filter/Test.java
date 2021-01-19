package kr.or.ddit.filter;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class Test {
	public static void main(String[] args) {
		for(Locale locale: SimpleDateFormat.getAvailableLocales()) {
			System.out.println(locale);
		}
	}
}
