package com.oppenheimer.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class WorkingClassHero {
    private String natid;
    private String name;
    private String gender;
    private String birthday;
    private BigDecimal salary;
    private BigDecimal tax;
}
