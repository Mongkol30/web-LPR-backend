package com.example.demo.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class carSearchModel {
    // private String lpId;
    @JsonProperty("licen_plates")
    private String lpNo;
    private Timestamp  lpDate;
    private Timestamp lpTime;

}
