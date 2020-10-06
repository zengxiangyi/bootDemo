package com.app.typeCare;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalTest {

	public static void main(String[] args) {
		String a = "2.345";
		String b = "6.789";
		BigDecimalTest t = new BigDecimalTest();

		System.out.println(t.add(a, b));
		System.out.println(t.sub(a, b));
		System.out.println(t.mul(a, b));
		System.out.println(t.div(a, b));
		System.out.println(t.round(a, 2));

	}

	public float add(String v1, String v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.add(b2).floatValue();
	}

	public float sub(String v1, String v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.subtract(b2).floatValue();
	}

	public float mul(String v1, String v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.multiply(b2).setScale(3, RoundingMode.HALF_UP).floatValue();
	}

	public float div(String v1, String v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.divide(b2, 3, BigDecimal.ROUND_HALF_UP).floatValue();
	}

	public float round(String v, int pos) {
		BigDecimal b = new BigDecimal(v);
		return b.setScale(pos, RoundingMode.HALF_UP).floatValue();
	}
}