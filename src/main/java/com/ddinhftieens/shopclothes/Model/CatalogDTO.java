package com.ddinhftieens.shopclothes.Model;

import java.util.Calendar;

public class CatalogDTO {
    private int ID;
    private String name;
    private CategoryDTO categoryDTO;
    private Calendar datecreated;

    public CatalogDTO() {
    }

    public CatalogDTO(String name,Calendar datecreated, CategoryDTO categoryDTO) {
        this.name = name;
        this.categoryDTO = categoryDTO;
        this.datecreated = datecreated;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }

    public Calendar getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Calendar datecreated) {
        this.datecreated = datecreated;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
