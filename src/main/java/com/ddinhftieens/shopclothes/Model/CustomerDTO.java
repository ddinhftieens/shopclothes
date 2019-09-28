package com.ddinhftieens.shopclothes.Model;

import org.springframework.web.multipart.MultipartFile;

public class CustomerDTO {
    private int ID;
    private String firseName,lastName,username,password,gender,dateofbirth,address,job,phone,email,role,imageUser,joindate;

    private MultipartFile multipartFile;

    public CustomerDTO() {
    }

    public CustomerDTO(String firseName, String lastName, String username, String password, String gender, String dateofbirth, String address, String job, String phone, String email, String role, String imageUser, String joindate) {
        this.firseName = firseName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.dateofbirth = dateofbirth;
        this.address = address;
        this.job = job;
        this.phone = phone;
        this.email = email;
        this.role = role;
        this.imageUser = imageUser;
        this.joindate = joindate;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public int getID() {
        return ID;
    }

    public String getFirseName() {
        return firseName;
    }

    public void setFirseName(String firseName) {
        this.firseName = firseName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getImageUser() {
        return imageUser;
    }

    public void setImageUser(String imageUser) {
        this.imageUser = imageUser;
    }

    public String getJoindate() {
        return joindate;
    }

    public void setJoindate(String joindate) {
        this.joindate = joindate;
    }

}
