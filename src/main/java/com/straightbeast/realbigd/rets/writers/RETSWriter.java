package com.straightbeast.realbigd.rets.writers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.admin.sample.ExampleItemWriter;
import org.springframework.batch.item.ItemWriter;

public class RETSWriter implements ItemWriter<Object> {

	private static final Log log = LogFactory.getLog(ExampleItemWriter.class);
	private boolean fail = false;
	
	public void setFail(boolean fail) {
		this.fail = fail;
	}

	/**
	 * @see ItemWriter#write(Object)
	 */
	public void write(List<? extends Object> data) throws Exception {
		log.info(data);
		
		
		if (fail ) {
			throw new RuntimeException("Planned failure");
		}
	}
	
}
