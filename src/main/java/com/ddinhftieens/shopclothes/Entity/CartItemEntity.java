package com.ddinhftieens.shopclothes.Entity;

import javax.persistence.*;

@Entity
@Table(name = "cart_item")
public class CartItemEntity{
    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDProduct",nullable = false)
    private ProductEntity idproduct;

    @Column(name = "Cost")
    private float cost;

    @Column(name = "Sale")
    private float sale;

    @Column(name = "BuyQuantity", nullable = false)
    private int buyQuantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDinvoice",nullable = false)
    private InvoiceEntity invoiceEntity;

    public CartItemEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProductEntity getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(ProductEntity idproduct) {
        this.idproduct = idproduct;
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

    public int getBuyQuantity() {
        return buyQuantity;
    }

    public void setBuyQuantity(int buyQuantity) {
        this.buyQuantity = buyQuantity;
    }

    public InvoiceEntity getInvoiceEntity() {
        return invoiceEntity;
    }

    public void setInvoiceEntity(InvoiceEntity invoiceEntity) {
        this.invoiceEntity = invoiceEntity;
    }
}
