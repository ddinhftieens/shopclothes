package com.ddinhftieens.shopclothes.Entity;

import javax.persistence.*;

@Entity
@Table(name = "news")
public class NewsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "titel")
    private String titel;

    @Column(name = "content")
    private String content;

    @Column(name = "datecreated")
    private String datecreated;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idadmin")
    private CustomerEntity customerEntity;

    @Column(name = "IDimage")
    private String IDimage;


    public NewsEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(String datecreated) {
        this.datecreated = datecreated;
    }

    public CustomerEntity getCustomerEntity() {
        return customerEntity;
    }

    public void setCustomerEntity(CustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getIDimage() {
        return IDimage;
    }

    public void setIDimage(String IDimage) {
        this.IDimage = IDimage;
    }
}
