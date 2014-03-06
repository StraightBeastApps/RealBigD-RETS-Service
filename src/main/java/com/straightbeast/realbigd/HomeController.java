package com.straightbeast.realbigd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.straightbeast.realbigd.persistence.domain.Property;
import com.straightbeast.realbigd.persistence.logic.PropertyLogic;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private PropertyLogic propertyLogic;
	
	@Scheduled()
	public void home() {
		Property p1 = new Property();
		p1.setAddress("1657 Estes Dr");
		p1.setPrice(new Float(100000.0));
		
		Property p2 = new Property();
		p2.setAddress("1600 Pennsylvania Ave");
		p2.setPrice(new Float(1750000.0));
		
		Property p3 = new Property();
		p3.setAddress("1667 Estes Dr");
		p3.setPrice(new Float(75000.0));
		
		propertyLogic.saveProperty(p1);
		propertyLogic.saveProperty(p2);
		propertyLogic.saveProperty(p3);
	}
	
}
