package com.example.demo.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "lpf_camera")
public class Lp01 {
    
	@Id
	@Column(name = "lp_id")
	private Integer lpId;

	@Column(name = "lp_no")
	private String lpNo;

	@Column(name = "lp_date")
	private Timestamp lpDate;

}
