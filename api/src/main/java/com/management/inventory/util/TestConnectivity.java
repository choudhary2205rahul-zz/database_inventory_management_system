package com.management.inventory.util;

import com.management.inventory.model.ProjectRequest;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
public class TestConnectivity {

    public static boolean checkConnectivity(ProjectRequest request) throws SQLException {

        String hostname = request.getInventory().getHostname();
        int port = request.getInventory().getPort();
        String schema = request.getInventory().getDbName();
        String username = request.getInventory().getUsername();
        String password = request.getInventory().getPassword();
        String dbtype = request.getInventory().getDbType();

        switch (dbtype) {
            case "MySQL":
                return checkDBConnectivity(hostname, port, schema, username, password);

            case "Oracle":
                break;

            case "H2":
                break;

            case "Postgres":
                break;

            default:
        }

        return false;
    }

    private static boolean checkDBConnectivity(String hostname, int port, String schema, String username, String password) throws SQLException {

        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://" + hostname + ":" + port + "/" + schema, username, password);
            boolean reachable = conn.isValid(10);// 10 sec
            return reachable;
        } catch (Exception e) {
            log.error("Error while connecting to DB", e);
        } finally {
            conn.close();
        }
        return false;

    }
}
