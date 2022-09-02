package com.oppenheimer.configs;

import lombok.Getter;

@Getter
public enum AgeVariable {
    AGE_AT_MOST_18(1),
    AGE_AT_MOST_35(0.8),
    AGE_AT_MOST_50(0.5),
    AGE_AT_MOST_75(0.367),
    AGE_AT_LEAST_76(0.05);

    private double variable;
    AgeVariable(double variable) {
        this.variable = variable;
    }
}
