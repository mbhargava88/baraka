package com.baraka.enums;

public enum CURRENCY {

    AED("Dirhams"),
    USD("United States Dollar");

    private final String statusDesc;

    CURRENCY(String statusDesc){
        this.statusDesc = statusDesc;
    }

    public String getStatusDesc() {
        return this.statusDesc;
    }
}
