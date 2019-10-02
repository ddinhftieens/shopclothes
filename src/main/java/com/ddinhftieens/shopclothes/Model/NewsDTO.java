package com.ddinhftieens.shopclothes.Model;

import org.springframework.web.multipart.MultipartFile;

import java.util.Calendar;

public class NewsDTO {
    private int id;
    private String IDimage;
    private String content,titel;
    private String datecreated;
    private CustomerDTO customerDTO;
    private MultipartFile multipartFile;

    public NewsDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIDimage() {
        return IDimage;
    }

    public void setIDimage(String IDimage) {
        this.IDimage = IDimage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(String datecreated) {
        this.datecreated = datecreated;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }


}
