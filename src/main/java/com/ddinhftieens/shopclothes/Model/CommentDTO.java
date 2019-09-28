package com.ddinhftieens.shopclothes.Model;

import java.util.Calendar;

public class CommentDTO {
    private int ID;
    private String comment;
    private CustomerDTO customerDTO;
    private ProductDTO productDTO;
    private Calendar datecomment;

    public CommentDTO() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public Calendar getDatecomment() {
        return datecomment;
    }

    public void setDatecomment(Calendar datecomment) {
        this.datecomment = datecomment;
    }
}
