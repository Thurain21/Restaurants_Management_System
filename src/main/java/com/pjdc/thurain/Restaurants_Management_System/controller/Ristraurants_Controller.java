package com.pjdc.thurain.Restaurants_Management_System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pjdc.thurain.Restaurants_Management_System.model.OrderData;
import com.pjdc.thurain.Restaurants_Management_System.model.Table;
import com.pjdc.thurain.Restaurants_Management_System.services.RestaurantServices.ServiceImpl;
@Controller
public class Ristraurants_Controller {
	
	@Autowired
	private ServiceImpl sip;
	
	@RequestMapping(value="/table/{tableId}", method = RequestMethod.GET)
	public ModelAndView insertData(@PathVariable (name="tableId")String tableId) {
		Table table = sip.updateTable(Integer.parseInt(tableId));
		ModelAndView model = new ModelAndView();
		model.addObject("table",table);
		model.setViewName("updateTable");
		return model;
	}
	
	@RequestMapping(value="/updateTableStatus")
	public ModelAndView updateTableStatus(@ModelAttribute Table table) {
		int UpdateResult = sip.updateTableStatus(table);
		ModelAndView model = new ModelAndView();
		model.addObject("UpdateResult",UpdateResult);
		model.setViewName("redirect:/RestaurantOrder");
		return model;
	}
	
	@RequestMapping(value="/Order")
	public ModelAndView showOrder() {
		List<OrderData> orderlist = sip.selectOrder();
		ModelAndView model = new ModelAndView();
		model.addObject("orderlist",orderlist);
		model.setViewName("orderDetails");
		return model;
	}

}
