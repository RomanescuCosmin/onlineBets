package com.sda.onlineBets.enums;

public enum BasketLeague {
    NBA("SUA - NBA"),
    SB_LEAGUE("Switzerland - SB LEAGUE"),
    LNB("France - LNB"),
    ACB("SPAIN - ACB"),
    SUPER_LIG ("TURKISH - Super Lig");

    private String name;


    BasketLeague(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
