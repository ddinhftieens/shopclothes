package com.ddinhftieens.shopclothes.Entity;

import javax.persistence.*;

@Entity
@Table(name = "evaluate")
public class EvaluateEntity {
    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "star")
    private int star;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idproduct")
    private ProductEntity productEntity;

    @JoinColumn(name = "idcustomer")
    @ManyToOne(fetch = FetchType.EAGER)
    private CustomerEntity customerEntity;

    public EvaluateEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public CustomerEntity getCustomerEntity() {
        return customerEntity;
    }

    public void setCustomerEntity(CustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
    }
}
