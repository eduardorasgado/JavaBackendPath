package com.eduardocode.designpatterns.creational.objectpool.connections;

public class Connection {
    String id;

    public Connection(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
