package com.springersbackend.pojo;

import java.util.Arrays;

public class ImagePojo {

	private int imageId;
	private String imageName;
	private String imageType;
	private byte[] imageByte;

	public ImagePojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ImagePojo(int imageId, String imageName, String imageType, byte[] imageByte) {
		super();
		this.imageId = imageId;
		this.imageName = imageName;
		this.imageType = imageType;
		this.imageByte = imageByte;
	}
	
	public ImagePojo(String imageName, String imageType, byte[] imageByte) {
		super();
		this.imageName = imageName;
		this.imageType = imageType;
		this.imageByte = imageByte;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public byte[] getImageByte() {
		return imageByte;
	}

	public void setImageByte(byte[] imageByte) {
		this.imageByte = imageByte;
	}

	@Override
	public String toString() {
		return "ImagePojo [imageId=" + imageId + ", imageName=" + imageName + ", imageType=" + imageType
				+ ", imageByte=" + Arrays.toString(imageByte) + "]";
	}

}
