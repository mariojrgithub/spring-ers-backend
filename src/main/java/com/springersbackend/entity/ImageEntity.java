package com.springersbackend.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "image_details")
public class ImageEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "image_id", columnDefinition = "serial")
	private int imageId;

	@Column(name = "image_name")
	private String imageName;

	@Column(name = "image_type")
	private String imageType;

	@Lob
	@Type(type="org.hibernate.type.BinaryType")
	@Column(name = "image_byte")
	private byte[] imageByte;

	public ImageEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ImageEntity(int imageId, String imageName, String imageType, byte[] imageByte) {
		super();
		this.imageId = imageId;
		this.imageName = imageName;
		this.imageType = imageType;
		this.imageByte = imageByte;
	}

	public ImageEntity(String imageName, String imageType, byte[] imageByte) {
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
		return "ImageEntity [imageId=" + imageId + ", imageName=" + imageName + ", imageType=" + imageType
				+ ", imageByte=" + Arrays.toString(imageByte) + "]";
	}

}
