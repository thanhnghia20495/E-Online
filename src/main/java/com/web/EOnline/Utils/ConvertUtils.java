package com.web.EOnline.Utils;

import java.text.NumberFormat;
import java.util.Locale;

public class ConvertUtils {
	public static String convertFormatPrice(long price) {
		Locale localeVN = new Locale("vi", "VN");
		NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
		String vnd = currencyVN.format(price);
		return vnd;
	}
}
