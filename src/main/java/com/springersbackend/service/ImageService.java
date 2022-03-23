package com.springersbackend.service;

import java.util.List;

import com.springersbackend.exceptions.SystemException;
import com.springersbackend.pojo.ImagePojo;

public interface ImageService {
	
	ImagePojo uploadImage(ImagePojo imagePojo) throws SystemException;
	
	List<ImagePojo> getAllImages() throws SystemException;

}
