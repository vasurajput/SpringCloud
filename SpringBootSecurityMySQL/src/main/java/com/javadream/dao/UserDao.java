package com.javadream.dao;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.javadream.model.User;

@Repository
public class UserDao {
	private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

	@Autowired
	private JdbcTemplate template;
	
	@Autowired
	private PasswordEncoder encoder;

	public User getUserInfo(String userName) {
		try {
			String sql = "SELECT u.username name, u.password pass, a.authority role FROM "
					+ "user u INNER JOIN authorities a on u.username=a.username WHERE "
					+ "u.enabled =1 and u.username = ?";
			List<Map<String, Object>> userResponse = template.queryForList(sql, new Object[] { userName });
			logger.info("vvv::  userResponse= " + userResponse);
			
			if (userResponse != null) {
				User user = new User(userResponse.get(0).get("name").toString(),
						userResponse.get(0).get("pass").toString(),
						userResponse.get(0).get("role").toString());
				
				logger.info("vvv:: user= " + user);
				return user;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}
	
	
	public int insertUser(User user) {
		try {
			String userName = user.getUserName();
			String pass = user.getPassword();
			String role = user.getRole();
			logger.info("vvv::  userName= "+userName + " ,pass= "+pass + ", role= "+role);
			int updateStatus = template.update("insert into user(username,password,enabled) values(?,?,?)", new Object[] {userName,encoder.encode(pass),"1"});
			logger.info("vvv::  updateStatus= "+updateStatus);
			if(updateStatus == 1) {
				int insertIntoAuthTable = template.update("insert into authorities(username,authority) values(?,?)", new Object[] {userName,role});
                logger.info("vvv::  insertIntoAuthTable = "+insertIntoAuthTable);
                if(insertIntoAuthTable == 1) {
                	return 1;
                }
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
