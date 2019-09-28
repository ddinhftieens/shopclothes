package com.ddinhftieens.shopclothes.Model;

import java.util.Calendar;

public class CommentAnswerDTO {
    private int ID;
    private String commentansewr;
    private CommentDTO commentDTO;
    private CustomerDTO customerDTO;
    private Calendar datecomment;

    public CommentAnswerDTO() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCommentansewr() {
        return commentansewr;
    }

    public void setCommentansewr(String commentansewr) {
        this.commentansewr = commentansewr;
    }

    public CommentDTO getCommentDTO() {
        return commentDTO;
    }

    public void setCommentDTO(CommentDTO commentDTO) {
        this.commentDTO = commentDTO;
    }

    public Calendar getDatecomment() {
        return datecomment;
    }

    public void setDatecomment(Calendar datecomment) {
        this.datecomment = datecomment;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }
}
