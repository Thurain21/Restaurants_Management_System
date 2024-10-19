package com.pjdc.thurain.Restaurants_Management_System.model;

public class OrderData {
	
	private int orderItemId;
	private String tableName;
	private String itemName;
	private int quantity;
	private String price;
	private String date;
	
	public OrderData(int orderItemId, String tableName, String itemName, int quantity, String price, String date) {
		
		this.orderItemId = orderItemId;
		this.tableName = tableName;
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
		this.date = date;
	}

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	

}
