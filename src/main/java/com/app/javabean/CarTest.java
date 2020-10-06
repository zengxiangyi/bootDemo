package com.app.javabean;

import com.app.util.JsonUtil;

public class CarTest {

	public static void main(String[] args) {
		
		Car car=new Car();
		car.setLicensePlate(null);
		car.setManufacturer("s");
		car.setSeatCount(-300);
		System.out.println(car.toString());
	}

}
