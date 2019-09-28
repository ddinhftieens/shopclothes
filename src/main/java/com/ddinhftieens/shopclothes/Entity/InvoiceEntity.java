package com.ddinhftieens.shopclothes.Entity;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "Invoice")
public class InvoiceEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="IDinvoice")
    private String idinvoice;
    @Column(name = "Name")
    private String name;
    @Column(name = "Address")
    private String address;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "Description")
    private String description;

    @Column(name = "Datecreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar datecreated;

    @Column(name = "Timerevice")
    @Temporal(TemporalType.DATE)
    private Calendar timerevice;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "invoiceEntity")
    private List<CartItemEntity> cartItems;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDcustomer")
    private CustomerEntity customerEntity;

    public InvoiceEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdinvoice() {
        return idinvoice;
    }

    public void setIdinvoice(String idinvoice) {
        this.idinvoice = idinvoice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Calendar getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Calendar datecreated) {
        this.datecreated = datecreated;
    }

    public Calendar getTimerevice() {
        return timerevice;
    }

    public void setTimerevice(Calendar timerevice) {
        this.timerevice = timerevice;
    }

    public List<CartItemEntity> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemEntity> cartItems) {
        this.cartItems = cartItems;
    }

    public CustomerEntity getCustomerEntity() {
        return customerEntity;
    }

    public void setCustomerEntity(CustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
    }
}
