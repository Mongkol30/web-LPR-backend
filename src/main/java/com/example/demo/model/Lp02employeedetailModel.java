package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


@Data
public class Lp02employeedetailModel {
    private String emp_Code;
    private String car_Licenseplate;
    private String car_Brand;
    private String car_Model;
    private String car_Color;
    private String cd_Id;

    private String emp_Name;
    private String emp_last_Name;
    private String emp_Phone;
    private String emp_job_Title;
    @JsonProperty("key")
    private String key;
    
}
