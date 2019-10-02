package com.ddinhftieens.shopclothes.Entity;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @Column(name = "ID",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "IDcode",nullable = false)
    private String IDcode;

    @Column(name = "Trademark")
    private String trademark;

    @Column(name = "Madein")
    private String madein;

    @Column(name = "Model")
    private String model;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CatalogID")
    private CatalogEntity catalogEntity;

    @Column(name = "JoinDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar joindate;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "productEntity")
    private List<ColorEntity> colorEntityList;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "productEntity")
    private List<CommentEntity> commentEntityList;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "productEntity")
    private List<ViewEntity> viewEntityList;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "productEntity")
    private List<EvaluateEntity> evaluateEntityList;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "productEntity")
    private StatusProductEntity statusProductEntity;

    public ProductEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIDcode() {
        return IDcode;
    }

    public void setIDcode(String IDcode) {
        this.IDcode = IDcode;
    }

    public String getTrademark() {
        return trademark;
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    public String getMadein() {
        return madein;
    }

    public void setMadein(String madein) {
        this.madein = madein;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public CatalogEntity getCatalogEntity() {
        return catalogEntity;
    }

    public void setCatalogEntity(CatalogEntity catalogEntity) {
        this.catalogEntity = catalogEntity;
    }

    public Calendar getJoindate() {
        return joindate;
    }

    public void setJoindate(Calendar joindate) {
        this.joindate = joindate;
    }

    public List<ColorEntity> getColorEntityList() {
        return colorEntityList;
    }

    public void setColorEntityList(List<ColorEntity> colorEntityList) {
        this.colorEntityList = colorEntityList;
    }

    public List<CommentEntity> getCommentEntityList() {
        return commentEntityList;
    }

    public void setCommentEntityList(List<CommentEntity> commentEntityList) {
        this.commentEntityList = commentEntityList;
    }

    public List<ViewEntity> getViewEntityList() {
        return viewEntityList;
    }

    public void setViewEntityList(List<ViewEntity> viewEntityList) {
        this.viewEntityList = viewEntityList;
    }

    public List<EvaluateEntity> getEvaluateEntityList() {
        return evaluateEntityList;
    }

    public void setEvaluateEntityList(List<EvaluateEntity> evaluateEntityList) {
        this.evaluateEntityList = evaluateEntityList;
    }

    public StatusProductEntity getStatusProductEntity() {
        return statusProductEntity;
    }

    public void setStatusProductEntity(StatusProductEntity statusProductEntity) {
        this.statusProductEntity = statusProductEntity;
    }
}
