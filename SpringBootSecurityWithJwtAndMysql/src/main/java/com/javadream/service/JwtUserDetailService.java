package com.javadream.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.javadream.dao.UserDAO;
import com.javadream.model.UserBean;

@Service
public class JwtUserDetailService implements UserDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(JwtUserDetailService.class);

	@Autowired
	private UserDAO dao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			UserBean userInfo = dao.getUserInfo(username);
			logger.info("vvv::  userInfo= " + userInfo);
			if (userInfo != null) {
				UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(
						userInfo.getUserName(), userInfo.getPassword(), new ArrayList<>());
				return userDetails;
			} else {
				throw new UsernameNotFoundException("User not found with username: " + username);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

}
