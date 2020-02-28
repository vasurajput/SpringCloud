package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@org.springframework.context.annotation.Configuration
public class Configuration {

	/* ********* For Database 1 *********** */
	@Bean(name = "datasource1")
	@ConfigurationProperties(prefix = "database1.datasource")
	@Primary
	public DataSource dataSource1() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "db1_template")
	public JdbcTemplate database_1_template(@Qualifier("datasource1") DataSource db1) {
		return new JdbcTemplate(db1);
	}
	
	
	/* ********* For Database 1 *********** */
	@Bean(name = "datasource2")
	@ConfigurationProperties(prefix = "database2.datasource")
	public DataSource dataSource2() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "db2_template")
	public JdbcTemplate database_2_template(@Qualifier("datasource2") DataSource db2) {
		return new JdbcTemplate(db2);
	}
}
