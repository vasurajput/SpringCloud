package com.example.demo.service;

import javax.transaction.Transactional;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class MainService {
	
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(MainService.class);
	
	private static final String query = "insert into testing(id,name) values(?,?)";

	@Autowired
	@Qualifier("db1_template")
	private JdbcTemplate template_database_1;
	
	@Autowired
	@Qualifier("db2_template")
	private JdbcTemplate template_database_2;
	
	@Transactional
	public int save() {
		try {
			int insertDB1Status = template_database_1.update(query, new Object[] {1,"vasu rajput"});
			logger.info("insertDB1Status= "+insertDB1Status);
			
			int insertDB2Status = template_database_2.update(query, new Object[] {2,"vishu rajput"});
			logger.info("insertDB1Status= "+insertDB1Status);
			
			return 1;
		} catch (Exception e) {
			logger.error("Exception: "+e);
			return 0;
		}
	}
}
