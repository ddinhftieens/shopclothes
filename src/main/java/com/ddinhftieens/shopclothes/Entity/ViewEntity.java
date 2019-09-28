package com.ddinhftieens.shopclothes.Entity;

import javax.persistence.*;

@Entity
@Table(name = "vieww")
public class ViewEntity {
    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idproduct")
    private ProductEntity productEntity;

    public ViewEntity() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }
}
