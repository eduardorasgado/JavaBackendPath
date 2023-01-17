package com.eduardocode.designpatterns.creational.objectpool.connections;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private List<Connection> availableConnections;
    private List<Connection> inUseConnections;
    private int maxSize;

    public ConnectionPool(int maxSize) {
        this.maxSize = maxSize;

        availableConnections = new ArrayList<>();
        inUseConnections = new ArrayList<>();

        for (int i = 0; i < maxSize; i++) {
            availableConnections.add(new Connection(String.format("C%d", i + 1)));
        }
    }

    public synchronized Connection getConnection() {
        System.out.print("Getting connection...");

        if(!availableConnections.isEmpty()) {
            Connection connection = availableConnections.remove(0);
            inUseConnections.add(connection);

            reportConnections(connection);
            return connection;
        }

        System.out.println("[There is no more connections available]");
        return null;
    }

    public synchronized void releaseConnection(Connection connection) {
        System.out.print("Releasing connection...");

        if (!availableConnections.contains(connection) && inUseConnections.contains(connection)) {
            inUseConnections.remove(connection);
            availableConnections.add(connection);

            reportConnections(connection);
        } else {
            System.out.println("[The connection was not able to be released]");
        }
    }

    public void reportConnections(Connection connection) {
        System.out.println(connection.getId());

        System.out.println("Connection pool status ->");

        System.out.println("available: " + availableConnections.size());
        System.out.println("in use: " + inUseConnections.size());
    }
}
