package com.pjdc.thurain.Restaurants_Management_System.model;

import java.util.List;

public class OrderForm {
    private List<DataForOrder> items;
    private int tableId;
    private String orderDate;

    public List<DataForOrder> getItems() {
        return items;
    }

    public void setItems(List<DataForOrder> items) {
        this.items = items;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
