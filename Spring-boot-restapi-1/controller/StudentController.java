package com.restapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.entity.Student;
import com.restapi.service.StudentService;

@RestController 
@RequestMapping("/student")

public class StudentController {
	
	@Autowired
	StudentService service;
	
	@PostMapping
	public ResponseEntity<String> addNewStudent(@RequestBody Student studentdetails)
	{
		int student_id = service.addStudentDetails(studentdetails);
		return new ResponseEntity<String>("new student inserted into DB with stdId:"+student_id, HttpStatus.OK);
	} 
	
	@GetMapping("/stdnumber/{studentnumber}")
	public ResponseEntity<Optional<Student>> getStudent(@PathVariable("studentnumber") int stdnumber){
		Optional<Student> student = service.getStudentByNumber(stdnumber);
		return new ResponseEntity<Optional<Student>>(student,HttpStatus.OK);
	}
  
}
