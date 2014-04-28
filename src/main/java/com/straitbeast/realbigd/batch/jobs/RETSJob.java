package com.straitbeast.realbigd.batch.jobs;

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

import com.straitbeast.realbigd.batch.config.InfrastructureConfiguration;
import com.straitbeast.realbigd.batch.processors.RETSProcessor;
import com.straitbeast.realbigd.batch.readers.RETSReader;
import com.straitbeast.realbigd.batch.writers.RETSWriter;

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
				.<SearchResultImpl,SearchResultImpl>chunk(1)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.build();
	}
	
	private ItemReader<SearchResultImpl> reader() {
		return new RETSReader();
	}
	
	private ItemProcessor<SearchResultImpl,SearchResultImpl> processor() {
		return new RETSProcessor();
	}
	
	private ItemWriter<SearchResultImpl> writer() {
		return new RETSWriter();
	}
	
}
