package com.example.demo.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSourceConfig extends HikariConfig {

	@Bean
	@Primary
	@ConfigurationProperties("app.primary-db")
	public DataSourceProperties firstDsProperties() {
		return new DataSourceProperties();
	}


	@Primary
	@Bean(name = "primary-db")
	@ConfigurationProperties("app.primary-db.configuration")
	public HikariDataSource primaryDataSource() {
		HikariDataSource dataSource = firstDsProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
		return dataSource;
	}

}