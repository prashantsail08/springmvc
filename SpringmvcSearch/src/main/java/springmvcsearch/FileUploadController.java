package springmvcsearch;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.log.UserDataHelper.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class FileUploadController {
	
	@RequestMapping("/fileform")
	public String showUploadForm()
	{
		System.out.println("fileform");
		
		//exception
		String str = null;
		System.out.println(str.length());
		
		return "fileform";
	}
	
	@RequestMapping(value = "/uploadimage", method = RequestMethod.POST)
	public String fileUpload(@RequestParam("profile") CommonsMultipartFile file, HttpSession session, Model model)
	{
		System.out.println("uploadImage handler");
		
		System.out.println(file.getSize());
		System.out.println(file.getContentType());
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getStorageDescription());
		
		//get the byte data
		byte [] data = file.getBytes(); //contains will be store in data it is in byte format
//		we have to save this file to server...
		String path =session.getServletContext().getRealPath("/")+"WEB-INF"+File.separator+"common"+File.separator
				+"image"+File.separator+file.getOriginalFilename(); //now it will upload in root folder and than the web-inf you will get file name
		System.out.println(path);
		
		
		try {
			
		FileOutputStream fos = new FileOutputStream(path);
		fos.write(data);
		fos.close();
		System.out.println("file Uploaded");
		
		model.addAttribute("msg", "uploaded successfuly");
		model.addAttribute("filename" , file.getOriginalFilename());
		
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("uploading error");
			model.addAttribute("msg", "uploading error");
		}
		
		return "filesuccess";
	}

}