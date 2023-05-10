package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class lp02cardetailModel {
    @JsonProperty("key")
    private Integer cd_Id;
    private String emp_Code;
    private String car_Licenseplate;
    private String car_Brand;
    private String car_Model;
    private String car_Color;
}
