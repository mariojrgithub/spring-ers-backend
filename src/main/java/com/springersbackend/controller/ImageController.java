package com.springersbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springersbackend.exceptions.SystemException;
import com.springersbackend.pojo.ImagePojo;
import com.springersbackend.service.ImageService;

@RestController
@RequestMapping("api")
public class ImageController {
	
	@Autowired
	ImageService imageService;
	
	// http://localhost:4444/api/manager/pic-upload
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("manager/pic-upload")
	ImagePojo uploadImage(@RequestParam("file") MultipartFile file) throws SystemException {
		return imageService.uploadImage(file);
	}
	
	// http://localhost:4444/api/manager/all-pics
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("manager/all-pics")
	List<ImagePojo> getAllImages() throws SystemException {
		return imageService.getAllImages();
	}
	
}
