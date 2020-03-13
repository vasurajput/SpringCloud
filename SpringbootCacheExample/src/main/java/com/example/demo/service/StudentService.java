package com.example.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Student;
import com.example.demo.repositry.StudentRepositry;

@Service
public class StudentService {

	private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

	@Autowired
	private StudentRepositry repositry;

	@Cacheable("student-cache")
	@Transactional(readOnly = true)
	public List<Student> getAllStudent() {
		try {
			List<Student> findAll = repositry.findAll();
			logger.info("vvv::  findAll= " + findAll);
			return findAll;
		} catch (Exception e) {
			logger.error("ERROR: " + e);
			return null;
		}
	}
	
	@CacheEvict(value = "student-cache")
	public void deleteStudent(Long studentId) {
		try {
			logger.info("vvv::  studentId= "+studentId);
			repositry.deleteById(studentId);
		} catch (Exception e) {
			logger.error("ERROR: "+e);
		}
	}
}
