package com.example.springbootexersicemain.model.enums;

public enum Number {

    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4");

    private final String value;

    Number(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}