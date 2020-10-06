package com.app.web;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.google.common.collect.Lists;

import com.app.excel.User;

@RestController
@RequestMapping("/excel")
public class ExcelWriteController{


    /**
     * 测试写入Excel文件
     * 
     * @param response
     * @throws IOException
     */
    @GetMapping("/download")
    public void doDownLoad(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("第一个文件", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        // 写入excel
        EasyExcel.write(response.getOutputStream(), User.class).sheet("模板").doWrite(getData());
    }
    
    public void page() {
        String fileName = "";
        ExcelWriter excelWriter = null;
        try {
            excelWriter = EasyExcel.write(fileName, User.class).build();
            WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
            excelWriter.write(getData(), writeSheet);
        } finally {
            // 千万别忘记finish 会帮忙关闭流
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }
    }
    
    
    public void writeData(String fileName) {   
    // 根据用户传入字段 假设我们只要导出 date
    Set<String> includeColumnFiledNames = new HashSet<String>();
    includeColumnFiledNames.add("date");
    // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
    EasyExcel.write(fileName, User.class).includeColumnFiledNames(includeColumnFiledNames).sheet("模板")
        .doWrite(getData());
    }
    
    /**
     * 构造假数据，实际上应该从数据库查出来
     * 
     * @return List<UserEntity>
     */
    private List<User> getData(){
        List<User> users = Lists.newArrayList();
        for (int i = 1; i <= 9; i++) {
            User user = new User();
            user.setBirthday(new Date());
            user.setName("user_" + i);
            user.setSalary(1.285 * i);
            user.setTelphone("1888888888" + i);
            users.add(user);
        }
        return users;
    }
}
