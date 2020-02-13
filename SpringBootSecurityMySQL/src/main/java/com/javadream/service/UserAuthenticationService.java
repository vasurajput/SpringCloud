package com.javadream.service;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.javadream.dao.UserDao;
import com.javadream.model.User;

@Service
public class UserAuthenticationService implements UserDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(UserAuthenticationService.class);

	@Autowired
	private UserDao dao;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			logger.info("vvv::  calling loadUserByUsername for username= " + username);
			User userInfo = dao.getUserInfo(username);
			GrantedAuthority authority = new SimpleGrantedAuthority(userInfo.getRole());
			UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(
					userInfo.getUserName(), userInfo.getPassword(), Arrays.asList(authority));

			return userDetails;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
