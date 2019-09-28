package com.ddinhftieens.shopclothes.Model;

public class ViewDTO {
    private int ID;
    private ProductDTO productDTO;

    public ViewDTO() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }
}
