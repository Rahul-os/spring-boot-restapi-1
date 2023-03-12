package com.restapi.demo.service;
import java.util.Optional;

import com.restapi.demo.entity.StudentEntity;


public interface StudentService {
	
	//implementing the basic CRUD operations for the Student Entity.
	
	 int addStudentDetails(StudentEntity student); 
	 
	 Optional<StudentEntity> getStudentByNumber(int stdnum); 
	 
	 int updateStudentDetails(StudentEntity student);
	 
	 int deleteStudent(int id);
}
