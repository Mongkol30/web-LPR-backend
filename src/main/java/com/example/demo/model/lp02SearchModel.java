package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class lp02SearchModel {
    private String emp_Code;
    @JsonProperty("key")
    private String emp_Name;
    private String emp_last_Name;
    private String emp_Phone;
    private String emp_job_Title;

}
