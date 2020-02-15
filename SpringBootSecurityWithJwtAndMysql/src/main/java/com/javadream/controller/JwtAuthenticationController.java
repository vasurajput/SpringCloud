package com.javadream.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javadream.dao.UserDAO;
import com.javadream.model.JwtResponse;
import com.javadream.model.UserBean;
import com.javadream.service.JwtUserDetailService;
import com.javadream.utility.JwtTokenUtility;

@RestController
public class JwtAuthenticationController {

	private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationController.class);

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtility jwtTokenUtil;

	@Autowired
	private JwtUserDetailService userDetailService;
	
	@Autowired
	private UserDAO dao;

	@PostMapping("/authenticateAPI")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody UserBean authenticationRequest) {
		try {
			logger.info("vvv::  Loading createAuthenticationToken for UserBean= " + authenticationRequest);
			authenticateUser(authenticationRequest.getUserName(), authenticationRequest.getPassword());
			final UserDetails userDetails = userDetailService.loadUserByUsername(authenticationRequest.getUserName());

			final String token = jwtTokenUtil.generateToken(userDetails);

			return ResponseEntity.ok(new JwtResponse(token));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@PostMapping("/insert")
    public String insert(@RequestBody UserBean user) {
        try {
            logger.info("vvv::  user= "+user);
            if(user == null) {
                return "Some technical error try again";
            }
            int insertUser = dao.insertUser(user);
            return "Insert Status= "+insertUser;
        } catch (Exception e) {
            e.printStackTrace();
            return "Some Technical Error Try Again";
        }
         
    }

	private void authenticateUser(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
