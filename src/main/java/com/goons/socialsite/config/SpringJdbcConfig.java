package com.goons.socialsite.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class SpringJdbcConfig {
    private static final String DB_HOST = System.getenv("DB_HOST");
    private static final String DB_USER = "postgres";
    private static final String DB_PASS = System.getenv("DB_PASS");
    private static final String CONN_STR = "jdbc:postgresql://"+ DB_HOST + "/";

    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(CONN_STR);
        dataSource.setUsername(DB_USER);
        dataSource.setPassword(DB_PASS);

        return dataSource;
    }

}
