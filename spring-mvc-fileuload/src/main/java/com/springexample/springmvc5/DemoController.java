package com.springexample.springmvc5;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.View;

@Controller
@RequestMapping(path = "/demo/")
public class DemoController {
	
	@RequestMapping(path = "/upload", method = RequestMethod.POST)
	
//	public String upload(MultipartHttpServletRequest req) {		
//		MultipartFile file = req.getFile("myfile"); //업로드된 파일 객체 반환
	
	public String upload(
			@RequestParam("myfile") MultipartFile[] files, HttpServletRequest req) {
		
		//String fileName = file.getOriginalFilename();
		// System.out.println(fileName);
		
		ServletContext application = req.getServletContext();
		String path = application.getRealPath("/upload-files");
		for (MultipartFile file : files) {
			
			String fileName = file.getOriginalFilename();
			System.out.println(fileName);
			
			try {
				File f = new File(path, fileName);
				file.transferTo( f ); //파일 저장
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		return "home";
	}
	
	@RequestMapping(path = "/download", method = RequestMethod.GET)
	public View download() {
		
		DownloadView dv = new DownloadView();
		
		return dv;
	}
	
	
}









