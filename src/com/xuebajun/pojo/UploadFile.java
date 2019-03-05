package com.xuebajun.pojo;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public class UploadFile {
	private String name;
	MultipartFile image;
    
    public MultipartFile getImage() {
        return image;
    }
 
    public void setImage(MultipartFile image) {
        this.image = image;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
