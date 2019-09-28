package com.ddinhftieens.shopclothes.Entity;


import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "category")
public class CategoryEntity {
    @Id
    @Column(name = "ID",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(name = "NameCategory")
    private String namecategory;

    @Column(name = "Datecreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar datecreated;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "categoryEntity")
    private List<CatalogEntity> catalogEntityList;

    public CategoryEntity() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNamecategory() {
        return namecategory;
    }

    public void setNamecategory(String namecategory) {
        this.namecategory = namecategory;
    }

    public Calendar getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Calendar datecreated) {
        this.datecreated = datecreated;
    }

    public List<CatalogEntity> getCatalogEntityList() {
        return catalogEntityList;
    }

    public void setCatalogEntityList(List<CatalogEntity> catalogEntityList) {
        this.catalogEntityList = catalogEntityList;
    }
}
