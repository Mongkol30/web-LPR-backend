package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "cardetail")
public class cardetail {

    @Id
	@Column(name = "cd_id")
	private Integer cd_Id;

	@Column(name = "emp_code")
	private String emp_Code;

	@Column(name = "car_licenseplate")
	private String car_Licenseplate;

	@Column(name = "car_brand")
	private String car_Brand;

	@Column(name = "car_model")
	private String car_Model;

    @Column(name = "car_color")
	private String car_Color;
    
}
