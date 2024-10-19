package com.pjdc.thurain.Restaurants_Management_System.model;

public class DataForOrder {
	
	private int orderId;
	private int tableId;
	private String orderDate;
	private int quantity;
	private String price;
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public DataForOrder(int orderId,int tableId ,String orderDate, String price , int quantity){
		this.orderId= orderId;
		this.tableId = tableId;
		this.orderDate = orderDate;
		this.price = price;
		this.quantity = quantity;
	}

}
