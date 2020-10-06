package com.app.excel;

import java.util.Date;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;

import lombok.Data;

@Data
@ColumnWidth(20)
@ContentRowHeight(10)
@HeadRowHeight(20)
public class User {

	// index--表示属性在第几列，value--表示标题
	@ExcelProperty(value = "姓名", index = 0)
	private String name;

	@DateTimeFormat("yyyy-MM-dd")
	@ExcelProperty(value = "生日", index = 1)
	private Date birthday;

	@ExcelProperty(value = "电话", index = 2)
	private String telphone;

	@NumberFormat("#.##")
	@ExcelProperty(value = "费用", index = 3)
	private double salary;

	@ExcelIgnore
	private String ignore;

}
