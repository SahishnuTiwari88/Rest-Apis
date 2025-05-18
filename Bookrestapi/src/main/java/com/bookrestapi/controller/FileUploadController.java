package com.bookrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bookrestapi.uploadfilehelper.FileUploadHelper;

@RestController
public class FileUploadController {

	@Autowired
	private FileUploadHelper fileUploadHelp;

	@PostMapping("/uploadfile")
	public ResponseEntity<String> uploadFle(@RequestParam("image") MultipartFile file) { // to fetch file data that we
																							// have submitted on postman
																							// we use @RequestParam

//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getContentType());
//		System.out.println(file.getSize());
//		System.out.println(file.getName());

		try {
			// we can use some condition on uploading file
			if (file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
			}

			if (!file.getContentType().equals("image/jpeg")) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only JPEG file is allowed");
			}

			// upload file(for that we have created a separate folder(Package) which handle
			// file uploading we just have to call it here

			boolean f = fileUploadHelp.uploadFile(file);
			if (f) {
				//return ResponseEntity.ok().body("File Uploaded succefully");
				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
				
				//ServletUriComponentsBuilder.fromCurrentContextPath() it will give current path to localhost i.e.8080, after that we 
				//add "/image" and finally add original file name so it gives file path(url)
			}
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Please try again");
	}

}
// note : server serves the file which is kept inside the target folder
