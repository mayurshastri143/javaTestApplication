package com.vaannila.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="image_upload")
public class ImageUpload {

	@Id
	@GeneratedValue
	@Column(name="ImageUploadId")
	private int imageUploadId;
	private byte[] image;
	private String imageName;
	private String contentType;
	private String filePath;
	
	@Column( name = "image" )
	@Type(type="binary")
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	@Column(name="ImageName")
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	@Column(name="ContentType")
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	@Column(name="FilePath")
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public int getImageUploadId() {
		return imageUploadId;
	}
	public void setImageUploadId(int imageUploadId) {
		this.imageUploadId = imageUploadId;
	}
	
	
}
