package com.example.bankcrudjee.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class connection {
    public static Connection  connect() {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/application_web","postgres"," ");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }

        return con;
    }
}
