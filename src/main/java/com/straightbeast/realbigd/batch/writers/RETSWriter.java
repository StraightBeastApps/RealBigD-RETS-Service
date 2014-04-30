package com.straightbeast.realbigd.batch.writers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.realtors.rets.client.SearchResultImpl;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.straightbeast.realbigd.persistence.dto.ResidentialDTO;
import com.straightbeast.realbigd.persistence.logic.ResidentialLogic;
import com.straightbeast.realbigd.persistence.utils.Utils;

public class RETSWriter implements ItemWriter<List<ResidentialDTO>> {

	private static final Log log = LogFactory.getLog(RETSWriter.class);
	private boolean fail = false;
	
	@Autowired
	private ResidentialLogic residentialLogic; 
	
	public void setFail(boolean fail) {
		this.fail = fail;
	}

	public void write(List<? extends List<ResidentialDTO>> items) throws Exception {
		for(List<ResidentialDTO> item : items){
			for(ResidentialDTO data : item){
				residentialLogic.save(data);
			}
		}
		
//		for( int i=0; i<items.size(); i++) {
//			ResidentialDTO res = new ResidentialDTO();
//			
//			res.setAddress(Utils.GREENVILLEMAP.get("address"));
//			res.setAddress2(Utils.GREENVILLEMAP.get("address2"));
//			res.setAddressDirection(Utils.GREENVILLEMAP.get("address_direction"));
//			res.setAddressNumber(Utils.GREENVILLEMAP.get("address_number"));
//			res.setAddressStreet(Utils.GREENVILLEMAP.get("address_street"));
//			res.setAgent(Utils.GREENVILLEMAP.get("agent"));
//			res.setAskingPrice(Integer.parseInt(Utils.GREENVILLEMAP.get("asking_price")));
//			res.setBathrooms(Float.parseFloat(Utils.GREENVILLEMAP.get("bathrooms")));
//			res.setBedrooms(Integer.parseInt(Utils.GREENVILLEMAP.get("bedrooms")));
//			res.setCity(Utils.GREENVILLEMAP.get("city"));
//			res.setCounty(Utils.GREENVILLEMAP.get("county"));
//			res.setDescription(Utils.GREENVILLEMAP.get("description"));
//			//res.setHotSheetDate(Utils.GREENVILLEMAP.get("hot_sheet_date"));
//			//res.setLastDocUpdate(Utils.GREENVILLEMAP.get("update_date"));
//			//res.setLastPhotoUpdate(Utils.GREENVILLEMAP.get("last_photo_update"));
//			res.setListAgent1(Integer.parseInt(Utils.GREENVILLEMAP.get("list_agent1")));
//			res.setMlsId(Long.parseLong(Utils.GREENVILLEMAP.get("mls_id")));
//			res.setListOffice1(Integer.parseInt(Utils.GREENVILLEMAP.get("list_office1")));
//			res.setNeighborhood(Utils.GREENVILLEMAP.get("neighborhood"));
//			res.setNumAcres(Integer.parseInt(Utils.GREENVILLEMAP.get("num_acres")));
//			res.setOffice(Utils.GREENVILLEMAP.get("office"));
//			res.setPictureCount(Integer.parseInt(Utils.GREENVILLEMAP.get("picture_count")));
//			//res.setPriceDate(Utils.GREENVILLEMAP.get("price_date"));
//			res.setSaleRent(Utils.GREENVILLEMAP.get("sale_rent"));
//			res.setSqrFtRange(Utils.GREENVILLEMAP.get("sqr_ft_range"));
//			res.setState(Utils.GREENVILLEMAP.get("state"));
//			res.setStatusCatId(Integer.parseInt(Utils.GREENVILLEMAP.get("status_cat_id")));
//			res.setStatusId(Integer.parseInt(Utils.GREENVILLEMAP.get("status_id")));
//			//res.setUpdateDate(Utils.GREENVILLEMAP.get("update_date"));
//			res.setYearBuilt(Integer.parseInt(Utils.GREENVILLEMAP.get("year_build")));
//			res.setZip(Utils.GREENVILLEMAP.get("zip"));
//			res.setZip6(Utils.GREENVILLEMAP.get("zip6"));
//			residentialLogic.save(res);
//		}		
	}
	
}
