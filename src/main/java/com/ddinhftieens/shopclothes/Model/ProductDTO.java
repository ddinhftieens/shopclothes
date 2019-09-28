package com.ddinhftieens.shopclothes.Model;

import org.springframework.web.multipart.MultipartFile;

import java.util.Calendar;
import java.util.List;

public class ProductDTO {
    private int ID;
    private String IDcode,trademark,madein,model;
    private CatalogDTO catalogDTO;
    private Calendar joindate;
    private int quantity;
    private MultipartFile multipartFile;
//    private List<ColorDTO> colorDTOList;

    public ProductDTO() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public CatalogDTO getCatalogDTO() {
        return catalogDTO;
    }

    public void setCatalogDTO(CatalogDTO catalogDTO) {
        this.catalogDTO = catalogDTO;
    }

    public Calendar getJoindate() {
        return joindate;
    }

    public void setJoindate(Calendar joindate) {
        this.joindate = joindate;
    }

//    public List<ColorDTO> getColorDTOList() {
//        return colorDTOList;
//    }
//
//    public void setColorDTOList(List<ColorDTO> colorDTOList) {
//        this.colorDTOList = colorDTOList;
//    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }
}
