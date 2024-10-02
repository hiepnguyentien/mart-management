package com.hiep.mart.domain.enumeration;

public enum CustomerStatus {
    AVAILABLE("AVAILABLE"),
    UNAVAILABLE("UNAVAILABLE");

    private final String value;
    CustomerStatus(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

}
