package com.ddinhftieens.shopclothes.Model;

import java.util.List;

public class InvoiceDTO {
    private CustomerDTO customerDTO;
    private int ID;
    private String name,address,phone,description,datecreated,timerevice,IDinvoice;

    public InvoiceDTO() {
    }

    public InvoiceDTO(CustomerDTO customerDTO, String name, String address, String phone, String description, String datecreated, String timerevice, String IDinvoice) {
        this.customerDTO = customerDTO;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.description = description;
        this.datecreated = datecreated;
        this.timerevice = timerevice;
        this.IDinvoice = IDinvoice;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public String getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(String datecreated) {
        this.datecreated = datecreated;
    }

    public String getTimerevice() {
        return timerevice;
    }

    public void setTimerevice(String timerevice) {
        this.timerevice = timerevice;
    }

    public String getIDinvoice() {
        return IDinvoice;
    }

    public void setIDinvoice(String IDinvoice) {
        this.IDinvoice = IDinvoice;
    }
}
