package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Teacher;
import com.example.demo.repository.TeacherRepository;

@Service
public class TeacherService {

	 @Autowired
	    TeacherRepository teacherRepository;
	 
	   
	  public Teacher getTeacherByIdService(Long id){
		  return teacherRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Contact Not Found"+id));

	  }
	  
}
