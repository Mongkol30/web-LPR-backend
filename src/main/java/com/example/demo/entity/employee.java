package com.example.demo.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "employee")
public class employee {
    
	@Id
	@Column(name = "emp_code")
	private Integer emp_Code;

	@Column(name = "emp_name")
	private String emp_Name;

	@Column(name = "emp_last_name")
	private String emp_last_Name;

	@Column(name = "emp_phone")
	private String emp_Phone;

	@Column(name = "emp_job_title")
	private String emp_job_Title;


}
