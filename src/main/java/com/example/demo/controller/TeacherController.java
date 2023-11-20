package com.example.demo.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Teacher;
import com.example.demo.repository.TeacherRepository;
import com.example.demo.service.TeacherService;

@RestController
public class TeacherController {

	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	TeacherService teacherService;
	
	@GetMapping(path="/teach",produces = APPLICATION_JSON_VALUE)
	public List<Teacher> getAllTeacher()
	{
		List<Teacher> list = teacherRepository.findAll();
		return list;
	}
		
	
	  @PostMapping("/teacher")
	    public ResponseEntity<Teacher> saveTeacher(@RequestBody Teacher teacher){
	        return ResponseEntity.ok(teacherRepository.save(teacher));
	    }
	  
	   @GetMapping("/teacher/{id}")
	    public ResponseEntity<Teacher> getTeacherById(@PathVariable Long id){
	        return ResponseEntity.ok(teacherService.getTeacherByIdService(id));
	    }


	    @DeleteMapping("/delteacher")
	    public void deleteTeacher(@RequestBody Teacher delteacher){
	    	teacherRepository.delete(delteacher);
	    }

	
}
