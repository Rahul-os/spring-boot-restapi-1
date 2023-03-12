package com.restapi.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name="StudentInfo")
public class StudentEntity {
	
	@Id
	private int stdid;
	
	@Column
	private String stdname;

	public int getStdid() {
		return stdid;
	}

	public void setStdid(int stdid) {
		this.stdid = stdid;
	}

	public String getStdname() {
		return stdname;
	}

	public void setStdname(String stdname) {
		this.stdname = stdname;
	}

	public StudentEntity(int stdid, String stdname) {
		
		this.stdid = stdid;
		this.stdname = stdname;
	}

	public StudentEntity() {
		
	} 
	
	

}
