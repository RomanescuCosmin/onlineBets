package com.sda.onlineBets.enums;

public enum TennisLeague {
    AUSTRALIAN_OPEN("SUA - NBA"),
    US_OPEN("ATP US Open");


    private String nameTennis;


    TennisLeague(String nameTennis) {
        this.nameTennis = nameTennis;
    }

    public String getNameTennis() {
        return nameTennis;
    }
}
