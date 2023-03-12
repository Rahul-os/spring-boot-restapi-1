package com.restapi.demo.controller;

import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.restapi.demo.entity.StudentEntity;
import com.restapi.demo.service.*;
@RestController 
@RequestMapping("/student")

public class StudentController {
	
	@Autowired
	StudentService service;
	
	@PostMapping
	public ResponseEntity<String> addNewStudent(@RequestBody StudentEntity studentdetails)
	{
		int student_id = service.addStudentDetails(studentdetails);
		return new ResponseEntity<String>("new student inserted into DB with stdId:"+student_id, HttpStatus.OK);
	} 
	
	@GetMapping("/stdnumber/{studentnumber}")
	public ResponseEntity<Optional<StudentEntity>> getStudent(@PathVariable("studentnumber") int stdnumber){
		Optional<StudentEntity> student = service.getStudentByNumber(stdnumber);
		if(student.isEmpty())
			return new ResponseEntity<Optional<StudentEntity>>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Optional<StudentEntity>>(student,HttpStatus.OK);
	}
	
	@PutMapping("update")
	public ResponseEntity<String> updateStudent(@RequestBody StudentEntity studentdetails)
	{
		int updated_studentid = service.updateStudentDetails(studentdetails);
		return new ResponseEntity<String>("Student details with STD_ID:"+updated_studentid+"updated",HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable int id)
	{
		int id1 = service.deleteStudent(id);
		return new ResponseEntity<String>("Student with id:"+id1+" deleted",HttpStatus.OK);
	}
}
