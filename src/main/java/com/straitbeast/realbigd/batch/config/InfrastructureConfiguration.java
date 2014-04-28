package com.straitbeast.realbigd.batch.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;

public interface InfrastructureConfiguration {

	@Bean
	public abstract DataSource dataSource();

}