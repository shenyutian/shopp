package com.syt.shopp.pojo;

import lombok.ToString;

@ToString
public class CartKey {
    private Integer userId;

    private String productId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}