package com.ddinhftieens.shopclothes.Entity;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "imageHome")
public class ImageHomeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "image")
    private String image;

    @Column(name = "datecreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar datecreated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ImageHomeEntity() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Calendar getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Calendar datecreated) {
        this.datecreated = datecreated;
    }
}
