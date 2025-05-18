package com.bookrestapi.uploadfilehelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	//static technique have to change from system to system
	//public final String UPLOAD_DIR = "/Users/SA20449357/Documents/workspace-spring-tool-suite-4-4.15.1.RELEASE/Bookrestapi/src/main/resources/static/image";
	
	
	//Dynamic for that we use ClassPathresource which will gives use dynamic path till resource folder and after that we just have 
	//mention the remaining folder inside resource folder
	//dynamic path
	public final String UPLOAD_DIR = new ClassPathResource("/static/image/").getFile().getAbsolutePath();
	
	public FileUploadHelper()throws IOException {
		//we are uploading file so it can throw exception so we use constructor and throws IOException
	}
	
	public boolean uploadFile(MultipartFile file) {//Multipart file object from previous variable contains the file
		
		boolean f = false;// by default indicate file is not uploaded
		
		try {
			
			//get data from MultipartFile(old method used) read data

			
		InputStream is = file.getInputStream();
		byte data[] = new byte[is.available()];
		is.read(data);//all data from 'is' stored in data
		
		//write data
		
		FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+File.separator+file.getOriginalFilename());//file.separator adds '/'
		fos.write(data);
		fos.flush();
		fos.close();
		
		//instead of using all above code we can do all this in single line of code
		//Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
		
		f=true;
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}

}
