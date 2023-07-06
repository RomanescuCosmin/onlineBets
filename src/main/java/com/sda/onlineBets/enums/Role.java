package com.sda.onlineBets.enums;

public enum Role {
    ROLE_USER("User"),
    ROLE_ADMIN("Admin");

    private String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}
