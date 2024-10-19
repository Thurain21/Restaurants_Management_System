package com.pjdc.thurain.Restaurants_Management_System.model;

public class Table {
	
	private int tableId;
	private String tableName;
	private String tableStatus;
	
	public Table(int tableId,String tableName,String tableStatus) {
		this.tableId = tableId;
		this.tableName=tableName;
		this.tableStatus = tableStatus;
	}

	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableStatus() {
		return tableStatus;
	}

	public void setTableStatus(String tableStatus) {
		this.tableStatus = tableStatus;
	}
	
	

}
