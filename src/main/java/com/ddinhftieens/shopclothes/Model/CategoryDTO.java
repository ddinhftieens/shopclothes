package com.ddinhftieens.shopclothes.Model;

import java.util.Calendar;


public class CategoryDTO {
    private int ID;
    private String name;
    private Calendar datecreated;

    public CategoryDTO() {
    }

    public CategoryDTO(String name, Calendar datecreated) {
        this.name = name;
        this.datecreated = datecreated;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Calendar datecreated) {
        this.datecreated = datecreated;
    }
}
