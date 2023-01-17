package com.eduardocode.designpatterns.creational.objectpool.connections;

public class ConnectionsDemo {

    public static void main(String[] args) {
        ConnectionPool pool = new ConnectionPool(3);

        Connection conn1 = pool.getConnection();
        Connection conn2 = pool.getConnection();

        pool.releaseConnection(conn1);

        Connection conn3 = pool.getConnection();

        pool.releaseConnection(conn2);
        pool.releaseConnection(conn3);

        //fail
        pool.releaseConnection(conn3);

        pool.getConnection();
        pool.getConnection();
        pool.getConnection();
        //fail
        pool.getConnection();
    }
}
