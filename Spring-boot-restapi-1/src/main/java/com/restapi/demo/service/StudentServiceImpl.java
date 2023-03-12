package com.restapi.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.demo.entity.StudentEntity;

import com.restapi.demo.repo.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository stdrepo;
	
	@Override
	public int addStudentDetails(StudentEntity studentdetails) {
		// TODO Auto-generated method stub
		
		stdrepo.save(studentdetails);
		
		return studentdetails.getStdid();
		
	}

	@Override
	public Optional<StudentEntity> getStudentByNumber(int stdnum) {
		// TODO Auto-generated method stub 
		Optional<StudentEntity> std = stdrepo.findById(stdnum);
		if(std.isEmpty())
			System.out.println("student not found!!!");
		return std;
	}

	@Override
	public int updateStudentDetails(StudentEntity studentdetails) {
		
		StudentEntity updated_details = stdrepo.save(studentdetails);
		return updated_details.getStdid();
		
	}

	@Override
	public int deleteStudent(int id) {
		
		stdrepo.deleteById(id);
		return id;
	}

	
	

}
