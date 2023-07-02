package com.sda.onlineBets.enums;

public enum League {
    SERIA_A("Italy - Seria A"),
    PREMIER_LEAGUE("England - Premier League"),
    LA_LIGA("Spain - La Liga"),
    SUPERLIGA("Romanian Liga 1 - Superliga");

    private String displayName;

    League(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
