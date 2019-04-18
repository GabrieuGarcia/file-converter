package com.dat.datdoc.model;

import java.math.BigDecimal;

public class SaleItem {

    private String id;
    private int itemQuantity;
    private BigDecimal itemPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public String toString() {
        return "SaleItem{" +
                "id='" + id + '\'' +
                ", itemQuantity=" + itemQuantity +
                ", itemPrice=" + itemPrice +
                '}';
    }
}
