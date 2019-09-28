package com.ddinhftieens.shopclothes.Entity;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "comment")
public class CommentEntity {
    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "namecomment")
    private String namecomment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idproduct")
    private ProductEntity productEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ipcustomer")
    private CustomerEntity customerEntity;

    @Column(name = "datecomment")
    @Temporal(TemporalType.DATE)
    private Calendar datecomment;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "commentEntity")
    private List<CommentAnswerEntity> commentAnswerEntityList;

    public CommentEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamecomment() {
        return namecomment;
    }

    public void setNamecomment(String namecomment) {
        this.namecomment = namecomment;
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

    public Calendar getDatecomment() {
        return datecomment;
    }

    public void setDatecomment(Calendar datecomment) {
        this.datecomment = datecomment;
    }

    public List<CommentAnswerEntity> getCommentAnswerEntityList() {
        return commentAnswerEntityList;
    }

    public void setCommentAnswerEntityList(List<CommentAnswerEntity> commentAnswerEntityList) {
        this.commentAnswerEntityList = commentAnswerEntityList;
    }
}
