package com.pjdc.thurain.Restaurants_Management_System.services;

import java.util.List;

import com.pjdc.thurain.Restaurants_Management_System.model.DataForOrder;
import com.pjdc.thurain.Restaurants_Management_System.model.Item;
import com.pjdc.thurain.Restaurants_Management_System.model.OrderData;
import com.pjdc.thurain.Restaurants_Management_System.model.Table;

public interface Services {
	
	public List<Table> selectTable();
	public Table updateTable(int tableId);
	public int updateTableStatus(Table table);
	public List<OrderData> selectOrder();
	public List<Item> selectItem();
	public int insertOrderData(List<DataForOrder> items, int tableId, String orderDate);

}
