package com.baraka.enums;

public enum ACCOUNT_TYPE {

    SAVINGS("Savings"),
    CURRENT("Current");

    private final String statusDesc;

    ACCOUNT_TYPE(String statusDesc){
        this.statusDesc = statusDesc;
    }

    public String getStatusDesc() {
        return this.statusDesc;
    }
}
