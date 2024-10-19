package com.pjdc.thurain.Restaurants_Management_System.services.RestaurantServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjdc.thurain.Restaurants_Management_System.model.OrderData;
import com.pjdc.thurain.Restaurants_Management_System.model.Table;
import com.pjdc.thurain.Restaurants_Management_System.repository.DataRepository;
import com.pjdc.thurain.Restaurants_Management_System.services.Services;

@Service
public class ServiceImpl implements Services{
	
	@Autowired
	 private DataRepository dr;	
	@Override
	public List<Table> selectTable() {
		return dr.selectTable();
		
	}

	@Override
	public Table updateTable(int tableId) {
		return dr.updateTable(tableId);
	}

	@Override
	public int updateTableStatus(Table table) {
		return dr.updateTableStatus(table);
	}

	@Override
	public List<OrderData> selectOrder() {
		return dr.selectOrder();
	}

}
