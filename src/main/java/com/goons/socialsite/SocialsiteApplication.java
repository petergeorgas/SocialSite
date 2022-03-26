package com.goons.socialsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

@SpringBootApplication
public class SocialsiteApplication {
    private static final String DB_HOST = System.getenv("DB_HOST");
    private static final String DB_USER = "postgres";
    private static final String DB_PASS = System.getenv("DB_PASS");
    private static final String CONN_STR = "jdbc:postgresql://"+ DB_HOST + "/" + DB_USER;

    public static void main(String[] args) {
        Connection c = connect();

        SpringApplication.run(SocialsiteApplication.class, args);
    }


    public static Connection connect() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(CONN_STR, DB_USER, DB_PASS);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return conn;
    }
}
