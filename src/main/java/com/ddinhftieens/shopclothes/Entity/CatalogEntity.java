package com.ddinhftieens.shopclothes.Entity;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "catalog")
public class CatalogEntity {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(name = "NameCatalog")
    private String namecatalog;

    @Column(name = "Datecreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar datecreated;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDcategory")
    private CategoryEntity categoryEntity;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "catalogEntity")
    private List<ProductEntity> productEntityList;

    public CatalogEntity() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNamecatalog() {
        return namecatalog;
    }

    public void setNamecatalog(String namecatalog) {
        this.namecatalog = namecatalog;
    }

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

    public Calendar getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Calendar datecreated) {
        this.datecreated = datecreated;
    }

    public List<ProductEntity> getProductEntityList() {
        return productEntityList;
    }

    public void setProductEntityList(List<ProductEntity> productEntityList) {
        this.productEntityList = productEntityList;
    }
}
