package com.springersbackend.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.springersbackend.dao.ImageDao;
import com.springersbackend.entity.ImageEntity;
import com.springersbackend.exceptions.SystemException;
import com.springersbackend.pojo.ImagePojo;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	ImageDao imageDao;

	public ImageServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ImagePojo uploadImage(MultipartFile file) throws SystemException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		ImageEntity imageEntity = null;
		try {
			imageEntity = new ImageEntity(fileName, file.getContentType(), file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		imageDao.save(imageEntity);

		ImagePojo imagePojo = new ImagePojo(imageEntity.getImageId(), imageEntity.getImageName(), imageEntity.getImageType(),
				imageEntity.getImageByte());

		return imagePojo;
	}

	@Override
	public List<ImagePojo> getAllImages() throws SystemException {
		List<ImagePojo> allImagesPojo = new ArrayList<ImagePojo>();
		List<ImageEntity> allImagesEntity = imageDao.findAll();
		for (ImageEntity imageEntity : allImagesEntity) {
			ImagePojo imagePojo = new ImagePojo(imageEntity.getImageId(), imageEntity.getImageName(),
					imageEntity.getImageType(), imageEntity.getImageByte());
			allImagesPojo.add(imagePojo);
		}

		return allImagesPojo;
	}

}
