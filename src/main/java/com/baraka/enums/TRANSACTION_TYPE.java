package com.baraka.enums;

public enum TRANSACTION_TYPE {

    DEBIT("Debit"),
    CREDIT("Credit");

    private final String statusDesc;

    TRANSACTION_TYPE(String statusDesc){
        this.statusDesc = statusDesc;
    }

    public String getStatusDesc() {
        return this.statusDesc;
    }
}
