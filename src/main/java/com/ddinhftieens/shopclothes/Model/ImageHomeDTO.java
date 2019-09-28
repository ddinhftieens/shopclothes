package com.ddinhftieens.shopclothes.Model;

import org.springframework.web.multipart.MultipartFile;

import java.util.Calendar;

public class ImageHomeDTO {

    private int id;
    private String image;
    private Calendar datecreated;
    private MultipartFile multipartFile;

    public ImageHomeDTO() {
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Calendar getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Calendar datecreated) {
        this.datecreated = datecreated;
    }
}
