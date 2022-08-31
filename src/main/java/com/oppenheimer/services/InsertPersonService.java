package com.oppenheimer.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class InsertPersonService {
    @Value("${host}")
    private String host;

    @Value("${port}")
    private String port;

    @Value("${calculatorCtrl.insertPerson.endpoint}")
    private String insertPersonEndpoint;

    @Value("${calculatorCtrl.insertMultiPerson.endpoint}")
    private String insertMultiPersonEndpoint;

    @Value("${calculatorCtrl.taxRelief.endpoint}")
    private String getTaxReliefEndpoint;

    @Value("${calculatorCtrl.uploadLargeFile.endpoint}")
    private String uploadLargeFileEndpoint;

    public void insertPerson() {

    }

    public void insertMultiPerson() {

    }

    public void getTaxRelief() {

    }

    public void rakeDatabase() {

    }
}
