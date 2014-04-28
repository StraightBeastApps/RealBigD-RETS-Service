package com.straitbeast.realbigd.batch.writers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.realtors.rets.client.SearchResultImpl;
import org.springframework.batch.item.ItemWriter;

public class RETSWriter implements ItemWriter<SearchResultImpl> {

	private static final Log log = LogFactory.getLog(RETSWriter.class);
	private boolean fail = false;
	
	public void setFail(boolean fail) {
		this.fail = fail;
	}

	public void write(List<? extends SearchResultImpl> items) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
