package com.example.product;

import javax.persistence.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="Product_table")
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long productId;
    private Integer qty;
    private String productName;
    private String orderStatus;
    private String deliveryId;
    private String deliveryStatus;

    // @PostPersist
    // public void onPostPersist(){
    //     OrderPlaced orderPlaced = new OrderPlaced();
    //     BeanUtils.copyProperties(this, orderPlaced);
    //     orderPlaced.publishAfterCommit();


    // }

    // @PreRemove
    // public void onPreRemove(){
    //     OrderCancelled orderCancelled = new OrderCancelled();
    //     BeanUtils.copyProperties(this, orderCancelled);
    //     orderCancelled.publishAfterCommit();

    //     //Following code causes dependency to external APIs
    //     // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

    //     //mall.external.Delivery delivery = new mall.external.Delivery();
    //     // mappings goes here
    //     OrderApplication.applicationContext.getBean(mall.external.DeliveryService.class)
    //         .cancelDelivery(this.getDeliveryId());


    // }

    @PostPersist
    public void eventPublish() {
        ProductChanged productChanged = new ProductChanged();
        productChanged.setProductId(this.getId());
        productChanged.setProductName(this.getProductName());
        productChanged.setProductStock(this.getQty());
        ObjectMapper objectMapper = new ObjectMapper();

        String json = null;

        try {
            json = objectMapper.writeValueAsString(productChanged);
        } catch (JsonProcessingException e) {
            //TODO: handle exception
            throw new RuntimeException("JSON format exception", e);
        }

        System.out.println(json);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }
    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }




}
