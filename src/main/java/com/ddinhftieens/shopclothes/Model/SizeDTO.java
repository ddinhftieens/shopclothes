package com.ddinhftieens.shopclothes.Model;

import java.util.Calendar;

public class SizeDTO {
    private int ID,quantity;
    private String sizeName;
    private ColorDTO colorDTO;
    private Calendar joindate;
    private float cost, sale;

    public SizeDTO() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public ColorDTO getColorDTO() {
        return colorDTO;
    }

    public void setColorDTO(ColorDTO colorDTO) {
        this.colorDTO = colorDTO;
    }

    public Calendar getJoindate() {
        return joindate;
    }

    public void setJoindate(Calendar joindate) {
        this.joindate = joindate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getSale() {
        return sale;
    }

    public void setSale(float sale) {
        this.sale = sale;
    }
}
