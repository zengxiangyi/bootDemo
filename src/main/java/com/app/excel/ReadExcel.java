package com.app.excel;

import com.alibaba.excel.EasyExcel;

public class ReadExcel {

	public static void main(String[] args) {			
		 String fileName = "E:\\demo\\in.xlsx";
	     EasyExcel.read(fileName, User.class, new UserListener()).sheet().doRead();
	}

}
