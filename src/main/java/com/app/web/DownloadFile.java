package com.app.web;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/file")
public class DownloadFile {

	@GetMapping(value = "/download")
	public ResponseEntity<FileSystemResource> getFile(@RequestParam String fileName) throws FileNotFoundException {
		String path = System.getProperty("user.dir") + "/data/";
		File file = new File(path + fileName);
		if (file.exists()) {
			return export(file);
		}
		System.out.println(file);
		return null;
	}

	public ResponseEntity<FileSystemResource> export(File file) {
		if (file == null) {
			return null;
		}
		HttpHeaders headers = new HttpHeaders();
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Content-Disposition", "attachment; filename=" + file.getName());
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		headers.add("Last-Modified", LocalDateTime.now().toString());
		headers.add("ETag", String.valueOf(System.currentTimeMillis()));
		return ResponseEntity.ok().headers(headers).contentLength(file.length())
				.contentType(MediaType.parseMediaType("application/octet-stream")).body(new FileSystemResource(file));
	}

	/**
	 * 稿源周报excel表格下载
	 * 
	 * @return
	 */

	@RequestMapping(value = "/downExcel", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String downExcel(HttpServletResponse response) throws UnsupportedEncodingException {
		LocalDate end = LocalDate.now();
		LocalDate start = end.minusDays(14);
		String filename = "稿源抓取周报-" + end.format(DateTimeFormatter.ISO_DATE) + ".xlsx";
		String filepath = "files/" + filename;
		// writeExcelFile(start, end, filepath);
		// 如果文件名不为空，则进行下载
		if (filename != null) {
			File file = new File(filepath);
			// 如果文件存在，则进行下载
			if (file.exists()) {
				// 配置文件下载
				response.setHeader("content-type", "application/octet-stream");
				response.setContentType("application/octet-stream");
				// 下载文件能正常显示中文
				response.setHeader("Content-Disposition",
						"attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
				// 实现文件下载
				byte[] buffer = new byte[1024];
				FileInputStream fis = null;
				BufferedInputStream bis = null;
				try {
					fis = new FileInputStream(file);
					bis = new BufferedInputStream(fis);
					OutputStream os = response.getOutputStream();
					int i = bis.read(buffer);
					while (i != -1) {
						os.write(buffer, 0, i);
						i = bis.read(buffer);
					}
					System.out.println("Download  successfully!");
					return "successfully";

				} catch (Exception e) {
					System.out.println("Download  failed!");
					return "failed";

				} finally {
					if (bis != null) {
						try {
							bis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (fis != null) {
						try {
							fis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		return "";
	}

}
