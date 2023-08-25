package com.example.demo.model;

import java.sql.Timestamp;


import lombok.Data;

@Data
public class ReprotModel {

    private String lpNo;
    private Timestamp lpDate;
    private Timestamp lpTime;
    private String startDate;
    private String endDate;
    private String emp_Code;
    private String emp_Name;
    private String emp_last_Name;
    private String emp_Phone;
    private String car_Brand;
    private String car_Model;
    private String car_Color;
    

}
