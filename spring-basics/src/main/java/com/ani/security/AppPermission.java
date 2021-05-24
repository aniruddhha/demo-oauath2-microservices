package com.ani.security;

public enum AppPermission {

    MACHINE_START("machine:start"),
    MACHINE_STOP("machine:stop"),

    WORKER_ACCESS("worker:access");

    private final String permission;

    AppPermission(String permission) {
        this.permission = permission;
    }
    public String getPermission() {
        return permission;
    }
}
