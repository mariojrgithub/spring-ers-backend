package com.springersbackend.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.springersbackend.exceptions.SystemException;
import com.springersbackend.pojo.ImagePojo;


public interface ImageService {
	
	ImagePojo uploadImage(MultipartFile file) throws SystemException;
	
	List<ImagePojo> getAllImages() throws SystemException;

}
