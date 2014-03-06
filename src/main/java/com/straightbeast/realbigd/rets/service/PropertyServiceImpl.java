package com.straightbeast.realbigd.rets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.straightbeast.realbigd.persistence.domain.Property;
import com.straightbeast.realbigd.persistence.logic.PropertyLogic;

@Service
public class PropertyServiceImpl implements PropertyService {

	@Autowired
	private PropertyLogic propertyLogic;
	
	@Override
	public void createProperty() {
		// TODO Auto-generated method stub
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
