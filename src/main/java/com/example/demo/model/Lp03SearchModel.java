package com.example.demo.model;

import java.sql.Timestamp;


import lombok.Data;

@Data
public class Lp03SearchModel {

    private String lpId;
    private String lpNo;
    private Timestamp lpDate;
    private Timestamp lpTime;
    private String startDate;
    private String endDate;

}
