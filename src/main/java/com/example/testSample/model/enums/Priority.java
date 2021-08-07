package com.example.testSample.model.enums;

public enum Priority {

    HIGH("فوری"),
    NORMAL("عادی"),
    LOW("غیرضروری");

    ;

    private String value;

    Priority(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

