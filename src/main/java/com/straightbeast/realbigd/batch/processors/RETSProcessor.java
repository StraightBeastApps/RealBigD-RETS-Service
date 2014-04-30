package com.straightbeast.realbigd.batch.processors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.realtors.rets.client.SearchResultImpl;
import org.springframework.batch.item.ItemProcessor;

import com.straightbeast.realbigd.persistence.dto.ResidentialDTO;
import com.straightbeast.realbigd.persistence.utils.Utils;

public class RETSProcessor implements ItemProcessor<SearchResultImpl, List<ResidentialDTO>> {

	
	
	public List<ResidentialDTO> process(SearchResultImpl item /*TODO: gimme the mls id*/) throws Exception {
		List<ResidentialDTO> results = new ArrayList<>(item.getRowCount());
		
		for(int i = 0; i < item.getRowCount(); i++){
			
			Map<String, Object> data = new HashMap<>(item.getColumns().length);
			
			for(int j = 0; j < item.getColumns().length; j++){
				//TODO get map from database
				data.put(Utils.GREENVILLEMAP.get(item.getColumns()[i]), item.getRow(j));
			}
			
			ResidentialDTO res = new ResidentialDTO();
			res.setData(data);
			
			results.add(res);
		}
		
		return results;
	}

}
