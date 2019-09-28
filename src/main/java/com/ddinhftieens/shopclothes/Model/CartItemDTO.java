package com.ddinhftieens.shopclothes.Model;

public class CartItemDTO {
    private int ID,quantity;
    private float cost, sale;
    private ProductDTO productDTO;
    private InvoiceDTO invoiceDTO;

    public CartItemDTO() {
    }

    public CartItemDTO(int quantity, float cost, float sale, ProductDTO productDTO, InvoiceDTO invoiceDTO) {
        this.quantity = quantity;
        this.cost = cost;
        this.sale = sale;
        this.productDTO = productDTO;
        this.invoiceDTO = invoiceDTO;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getSale() {
        return sale;
    }

    public void setSale(float sale) {
        this.sale = sale;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public InvoiceDTO getInvoiceDTO() {
        return invoiceDTO;
    }

    public void setInvoiceDTO(InvoiceDTO invoiceDTO) {
        this.invoiceDTO = invoiceDTO;
    }
}
