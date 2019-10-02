package com.ddinhftieens.shopclothes.Entity;

import javax.persistence.*;

@Entity
@Table(name = "statusProduct")
public class StatusProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "status")
    private String status;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idproduct")
    private ProductEntity productEntity;

    public StatusProductEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }
}
