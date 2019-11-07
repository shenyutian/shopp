package com.syt.shopp.pojo;

import lombok.ToString;

/**
 * @author syt
 */
@ToString
public class Cart extends CartKey {
    private Integer addNum;

    public Integer getAddNum() {
        return addNum;
    }

    public void setAddNum(Integer addNum) {
        this.addNum = addNum;
    }
}