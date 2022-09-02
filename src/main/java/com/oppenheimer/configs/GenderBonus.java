package com.oppenheimer.configs;

import lombok.Getter;

@Getter
public enum GenderBonus {
    M(0),
    F(500);

    private final int bonus;

    GenderBonus(int bonus) {
        this.bonus = bonus;
    }
}
