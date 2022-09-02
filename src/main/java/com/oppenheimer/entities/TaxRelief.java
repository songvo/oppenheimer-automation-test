package com.oppenheimer.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TaxRelief {
    private String natid;
    private String name;
    private String relief;
}
