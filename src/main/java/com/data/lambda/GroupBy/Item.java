package com.data.lambda.GroupBy;

import java.math.BigDecimal;

/**
 * @Auther: ljh
 * @Date: 2018/11/21 11:21
 * @Description:
 */
public class Item {

    private String name;
    private int qty;
    private BigDecimal price;

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Item(String name, int qty, BigDecimal price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

}
