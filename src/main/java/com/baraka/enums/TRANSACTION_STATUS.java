package com.baraka.enums;

public enum TRANSACTION_STATUS {

    SUCCESS("Success"),
    FAILED("Failed"),
    WAITING("Waiting");

    private final String statusDesc;

    TRANSACTION_STATUS(String statusDesc){
        this.statusDesc = statusDesc;
    }

    public String getStatusDesc() {
        return this.statusDesc;
    }
}
