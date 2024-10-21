package com.pjdc.thurain.Restaurants_Management_System.model;

public class DataForOrder {
    private int itemId;
    private int quantity;
    private String price;

    public DataForOrder() { }

    public DataForOrder(int itemId, int quantity, String price) {
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
