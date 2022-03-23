package com.springersbackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public ImagePojo uploadImage(ImagePojo imagePojo) throws SystemException {
		ImageEntity imageEntity = new ImageEntity(imagePojo.getImageId(), imagePojo.getImageName(),
				imagePojo.getImageType(), imagePojo.getImageByte());

		imageDao.save(imageEntity);

		imagePojo = new ImagePojo(imageEntity.getImageId(), imageEntity.getImageName(), imageEntity.getImageType(),
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
