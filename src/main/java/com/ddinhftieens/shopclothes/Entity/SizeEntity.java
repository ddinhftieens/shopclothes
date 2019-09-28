package com.ddinhftieens.shopclothes.Entity;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "size")
public class SizeEntity {
    @Id
    @Column(name = "ID",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "sizeName")
    private String sizeName;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "cost")
    private float cost;

    @Column(name = "sale")
    private float sale;

    @Column(name="joindate")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar joindate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idcolor")
    private ColorEntity colorEntity;

    public SizeEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public Calendar getJoindate() {
        return joindate;
    }

    public void setJoindate(Calendar joindate) {
        this.joindate = joindate;
    }

    public ColorEntity getColorEntity() {
        return colorEntity;
    }

    public void setColorEntity(ColorEntity colorEntity) {
        this.colorEntity = colorEntity;
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
