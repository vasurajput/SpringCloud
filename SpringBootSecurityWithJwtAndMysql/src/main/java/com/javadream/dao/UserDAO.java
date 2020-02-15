package com.javadream.dao;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.javadream.model.UserBean;

@Repository
public class UserDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDAO.class);
	
	@Autowired
    private PasswordEncoder encoder;

	@Autowired
	private JdbcTemplate template;
	
	public UserBean getUserInfo(String userName) {
		try {
			String query = "select * from userDetail where userName=?";
			List<Map<String, Object>> userResponse = template.queryForList(query, new Object[] {userName});
			logger.info("vvv::  userResponse= "+userResponse);
			if(userName !=null) {
				UserBean userBean = new UserBean(userResponse.get(0).get("username").toString(),
						userResponse.get(0).get("password").toString());
				return userBean;
			}
		} catch (Exception e) {
			logger.error(e.getStackTrace().toString());
		}
		return null;
	}
	
	   public int insertUser(UserBean user) {
	        try {
	            String userName = user.getUserName();
	            String pass = user.getPassword();

	            logger.info("vvv::  userName= "+userName + " ,pass= "+pass );
	            int updateStatus = template.update("insert into userDetail(username,password) values(?,?)", new Object[] {userName,encoder.encode(pass)});
	            logger.info("vvv::  updateStatus= "+updateStatus);
	            if(updateStatus == 1) {
	             return 1;
	            }
	            return 0;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return 0;
	        }
	    }
}
