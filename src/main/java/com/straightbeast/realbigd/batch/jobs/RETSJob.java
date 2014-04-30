package com.straightbeast.realbigd.batch.jobs;

import java.util.List;

import org.realtors.rets.client.SearchResultImpl;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.straightbeast.realbigd.batch.config.InfrastructureConfiguration;
import com.straightbeast.realbigd.batch.processors.RETSProcessor;
import com.straightbeast.realbigd.batch.readers.RETSReader;
import com.straightbeast.realbigd.batch.writers.RETSWriter;
import com.straightbeast.realbigd.persistence.dto.ResidentialDTO;

@Configuration
public class RETSJob {
	
	@Autowired
	private JobBuilderFactory jobBuilders;
	
	@Autowired
	private StepBuilderFactory stepBuilders;
	
	@Autowired
	private InfrastructureConfiguration infrastructureConfiguration;
	
	RETSReader reader;
	RETSProcessor processor;
	RETSWriter writer;
	
	@Bean
	public Job threeRJob(){
		return jobBuilders.get("RETSJob")
				.start(step())
				.build();
	}
	
	@Bean
	public Step step(){
		return stepBuilders.get("step")
				.<SearchResultImpl,List<ResidentialDTO>>chunk(1)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.build();
	}
	
	private ItemReader<SearchResultImpl> reader() {
		return new RETSReader();
	}
	
	private ItemProcessor<SearchResultImpl,List<ResidentialDTO>> processor() {
		return new RETSProcessor();
	}
	
	private ItemWriter<List<ResidentialDTO>> writer() {
		return new RETSWriter();
	}
	
}
