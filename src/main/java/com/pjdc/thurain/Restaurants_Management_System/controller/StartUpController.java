package com.pjdc.thurain.Restaurants_Management_System.controller;

import org.springframework.web.servlet.ModelAndView;

public class StartUpController {
	
	public ModelAndView startUp() {
		ModelAndView model = new ModelAndView();
		model.addObject(model);
		model.setViewName("restaurant");
		return model;
	}

}
