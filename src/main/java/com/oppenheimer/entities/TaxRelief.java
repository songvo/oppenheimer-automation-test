package com.oppenheimer.entities;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaxRelief {
    private String natid;
    private String name;
    private String relief;
}
