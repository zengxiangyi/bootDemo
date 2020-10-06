package com.app.excel;

import java.util.List;
import java.util.Map;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.CellExtra;
import com.app.util.JsonUtil;

public class UserListener extends AnalysisEventListener<User> {

	// 一行一行读取excel内容
	@Override
	public void invoke(User data, AnalysisContext analysisContext) {
		System.out.println(data.toString());
	}

	// 读取表头内容
	@Override
	public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
		System.out.println("表头：" + headMap);
	}

	// 读取完成之后
	@Override
	public void doAfterAllAnalysed(AnalysisContext analysisContext) {
		System.out.println("读取完毕");
	}

	@Override
	public void invokeHead(Map<Integer, CellData> headMap, AnalysisContext context) {
		System.out.println("读取标题行");
		super.invokeHead(headMap, context);
	}

	@Override
	public void extra(CellExtra extra, AnalysisContext context) {
		System.out.println("发生额外信息");
		super.extra(extra, context);
	}

	@Override
	public void onException(Exception exception, AnalysisContext context) throws Exception {
		System.out.println("发生错误");
		super.onException(exception, context);
	}

	@Override
	public boolean hasNext(AnalysisContext context) {
		System.out.println("有下一个元素");
		return super.hasNext(context);
	}

	public void synchronousRead() {
		String fileName = "demo.xlsx";
		// 这里 需要指定读用哪个class去读，然后读取第一个sheet 同步读取会自动finish
		List<User> list = EasyExcel.read(fileName).head(User.class).sheet().doReadSync();
		for (User data : list) {
			System.out.println("读取到数据:" + JsonUtil.toJsonStr(data));
		}
	}

}