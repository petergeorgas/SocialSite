package com.goons.socialsite;

import com.goons.socialsite.config.SpringJdbcConfig;
import com.goons.socialsite.util.Logging;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

@SpringBootApplication
public class SocialsiteApplication {

    public static void main(String[] args) {
        SpringJdbcConfig springJdbcConfig = new SpringJdbcConfig();
        DataSource dataSource = springJdbcConfig.getDataSource();

        try {
            dataSource.getConnection(); // Confirm that we have a connection to the DB.
            Logging.logger.info("Successfully connected to Postgres");
        } catch (SQLException e){
            Logging.logger.error(e);
            System.exit(-1);
        }


        SpringApplication.run(SocialsiteApplication.class, args);
    }


}
