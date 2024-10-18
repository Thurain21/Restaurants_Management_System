package com.pjdc.thurain.Restaurants_Management_System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pjdc.thurain.Restaurants_Management_System.model.Table;
import com.pjdc.thurain.Restaurants_Management_System.services.RestaurantServices.ServiceImpl;

@Controller
public class StartUpController {
	
	@Autowired
	private ServiceImpl sip ;
	
	@RequestMapping(value="/RestaurantOrder" , method = RequestMethod.GET)
	public ModelAndView startUp() {
		List<Table> tablelist = sip.selectTable();
		ModelAndView model = new ModelAndView();
		model.addObject("tablelist",tablelist);
		model.setViewName("RestaruantOrder");
		return model;
	}

}
