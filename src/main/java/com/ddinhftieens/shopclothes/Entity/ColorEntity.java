package com.ddinhftieens.shopclothes.Entity;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "color")
public class ColorEntity {

    @Id
    @Column(name = "ID",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "colorName")
    private String colorName;

    @Column(name = "material")
    private String meterial;
    @Column(name="description")
    private String description;
    @Column(name = "fileImage")
    private String fileImage;

    @Column(name="joindate")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar joindate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idproduct")
    private ProductEntity productEntity;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "colorEntity")
    private List<SizeEntity> sizeEntityList;

    public ColorEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getMeterial() {
        return meterial;
    }

    public void setMeterial(String meterial) {
        this.meterial = meterial;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFileImage() {
        return fileImage;
    }

    public void setFileImage(String fileImage) {
        this.fileImage = fileImage;
    }

    public Calendar getJoindate() {
        return joindate;
    }

    public void setJoindate(Calendar joindate) {
        this.joindate = joindate;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public List<SizeEntity> getSizeEntityList() {
        return sizeEntityList;
    }

    public void setSizeEntityList(List<SizeEntity> sizeEntityList) {
        this.sizeEntityList = sizeEntityList;
    }
}
