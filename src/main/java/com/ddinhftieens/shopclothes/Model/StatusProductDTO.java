package com.ddinhftieens.shopclothes.Model;

public class StatusProductDTO {
    private int id;
    private String status;
    private ProductDTO productDTO;

    public StatusProductDTO() {
    }

    public StatusProductDTO(String status, ProductDTO productDTO) {
        this.status = status;
        this.productDTO = productDTO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }
}
