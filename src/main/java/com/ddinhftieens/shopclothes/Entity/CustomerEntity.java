package com.ddinhftieens.shopclothes.Entity;
import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "customer")
public class CustomerEntity {
    @Id
    @Column(name = "ID",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "FirstName", nullable = false)
    private String firstname;
    @Column(name = "LastName", nullable = false)
    private String lastname;
    @Column(name = "Gender", nullable = false)
    private String gender;
    @Column(name = "Job", nullable = false)
    private String job;

    @Column(name = "Birthday")
    @Temporal(TemporalType.DATE)
    private Calendar birthday;

    @Column(name = "address")
    private String address;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email",nullable = true)
    private String email;

    @Column(name = "avatar_file_name")
    private String avatarFileName;

    @Column(name = "joindate")
    private String joindate;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customerEntity")
    private List<InvoiceEntity> invoiceEntityList;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "customerEntity")
    private List<CommentEntity> commentEntityList;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "customerEntity")
    private List<CommentAnswerEntity> commentAnswerEntityList;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "customerEntity")
    private List<EvaluateEntity> evaluateEntityList;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "customerEntity")
    private List<NewsEntity> newsEntityList;

    public CustomerEntity() {
    }

    public List<EvaluateEntity> getEvaluateEntityList() {
        return evaluateEntityList;
    }

    public void setEvaluateEntityList(List<EvaluateEntity> evaluateEntityList) {
        this.evaluateEntityList = evaluateEntityList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatarFileName() {
        return avatarFileName;
    }

    public void setAvatarFileName(String avatarFileName) {
        this.avatarFileName = avatarFileName;
    }

    public String getJoindate() {
        return joindate;
    }

    public void setJoindate(String joindate) {
        this.joindate = joindate;
    }

    public List<InvoiceEntity> getInvoiceEntityList() {
        return invoiceEntityList;
    }

    public void setInvoiceEntityList(List<InvoiceEntity> invoiceEntityList) {
        this.invoiceEntityList = invoiceEntityList;
    }

    public List<CommentEntity> getCommentEntityList() {
        return commentEntityList;
    }

    public void setCommentEntityList(List<CommentEntity> commentEntityList) {
        this.commentEntityList = commentEntityList;
    }

    public List<CommentAnswerEntity> getCommentAnswerEntityList() {
        return commentAnswerEntityList;
    }

    public void setCommentAnswerEntityList(List<CommentAnswerEntity> commentAnswerEntityList) {
        this.commentAnswerEntityList = commentAnswerEntityList;
    }

    public List<NewsEntity> getNewsEntityList() {
        return newsEntityList;
    }

    public void setNewsEntityList(List<NewsEntity> newsEntityList) {
        this.newsEntityList = newsEntityList;
    }
}
