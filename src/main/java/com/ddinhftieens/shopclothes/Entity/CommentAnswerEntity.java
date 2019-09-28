package com.ddinhftieens.shopclothes.Entity;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name="commentasnwer")
public class CommentAnswerEntity {
    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @Column(name = "namecomment")
    private String namecomment;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idcomment")
    private CommentEntity commentEntity;
    @Column(name = "datecomment")
    @Temporal(TemporalType.DATE)
    private Calendar datecomment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idcustomer")
    private CustomerEntity customerEntity;

    public CommentAnswerEntity() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNamecomment() {
        return namecomment;
    }

    public void setNamecomment(String namecomment) {
        this.namecomment = namecomment;
    }

    public CommentEntity getCommentEntity() {
        return commentEntity;
    }

    public void setCommentEntity(CommentEntity commentEntity) {
        this.commentEntity = commentEntity;
    }

    public Calendar getDatecomment() {
        return datecomment;
    }

    public void setDatecomment(Calendar datecomment) {
        this.datecomment = datecomment;
    }
}
