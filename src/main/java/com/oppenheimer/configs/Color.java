package com.oppenheimer.configs;

import lombok.Getter;

@Getter
public enum Color {
    RED("#dc3545");

    private final String colorCode;

    Color(String colorCode) {
        this.colorCode = colorCode;
    }
}
