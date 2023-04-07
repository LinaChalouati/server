package com.actia.monitoring.server.model;

import lombok.Getter;

@Getter

public enum Status {
    SERVER_UP("Server_UP"),
    SERVER_DOWN("Server_DOWN");
    private final String status;
    Status(String status){
        this.status=status;
    }

}
