package com.web.EOnline.Utils;

import java.io.ByteArrayOutputStream;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class ConvertUtils {
	public static String convertFormatPrice(long price) {
		Locale localeVN = new Locale("vi", "VN");
		NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
		String vnd = currencyVN.format(price);
		return vnd;
	}

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	public static boolean validate(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}
	
	public static String currentHerf(String keyword, int price, int height, int weight, int category, int trading) {
		String param = "";
		if (keyword!="") {
			param = param + "&keyword=" + keyword;
		}
		if (price!=0) {
			param = param + "&price=" + price;
		}
		if (height!=0) {
			param = param + "&height=" + height;
		}
		if (weight!=0) {
			param = param + "&weight=" + weight;
		}
		if (category!=0) {
			param = param + "&category=" + category;
		}
		if (trading!=0) {
			param = param + "&trading=" + trading;
		}
		return param;
	}
	
	public static byte[] getQRCodeImage(String text, int width, int height) {
		try {
			QRCodeWriter qrCodeWriter = new QRCodeWriter();
			BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			MatrixToImageWriter.writeToStream(bitMatrix, "png", byteArrayOutputStream);
			return byteArrayOutputStream.toByteArray();
		} catch (Exception e) {
			return null;
		}
	}
}
