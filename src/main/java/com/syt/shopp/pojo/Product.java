package com.syt.shopp.pojo;

import lombok.ToString;

/**
 * @author syt
 * 电脑类
 */
@ToString
public class Product {
    private String productId;

    private String productName;

    private String brand;

    private Double price;

    private Integer stockNum;

    private String imgUrl;

    private String productInfor;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStockNum() {
        return stockNum;
    }

    public void setStockNum(Integer stockNum) {
        this.stockNum = stockNum;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getProductInfor() {
        return productInfor;
    }

    public void setProductInfor(String productInfor) {
        this.productInfor = productInfor;
    }
}