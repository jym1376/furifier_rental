package com.example.product;

public class ProductChanged {
    String eventType;
    Long productId;
    String productName;
    int productStock;

    public String getEventType() {
        return this.eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Long getProductId() {
        return this.productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductStock() {
        return this.productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    public ProductChanged() {
        this.eventType = this.getClass().getSimpleName();
    }


}
