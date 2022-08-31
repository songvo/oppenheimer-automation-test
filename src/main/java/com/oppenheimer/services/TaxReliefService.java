package com.oppenheimer.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TaxReliefService {

    @Value("${calculatorCtrl.taxRelief.endpoint}")
    private String getTaxReliefEndpoint;
    public void getTaxRelief() {

    }
}
