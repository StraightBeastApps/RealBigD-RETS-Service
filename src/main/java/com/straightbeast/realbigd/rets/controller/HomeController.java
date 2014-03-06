package com.straightbeast.realbigd.rets.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.straightbeast.realbigd.rets.service.PropertyService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private PropertyService propertyService;
	
	@RequestMapping( value = "/hello", method = RequestMethod.GET )
	public String helloWorld(Locale locale, Model model){
		
		logger.info("Welcome home! The client locale is {}.", locale );
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@Scheduled(fixedDelay=5000)
	public void home() {
		logger.info("scheduled job waking up");
		
		propertyService.createProperty();
	}
	
}
