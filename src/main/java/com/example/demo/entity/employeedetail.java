package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.Data;

@Data
public class employeedetail {

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

    @Column(name = "car_licenseplate")
	private String car_Licenseplate;

	@Column(name = "car_brand")
	private String car_Brand;

	@Column(name = "car_model")
	private String car_Model;

    @Column(name = "car_color")
	private String car_Color;

    @Column(name = "cd_id")
	private String cd_Id;
    
}
