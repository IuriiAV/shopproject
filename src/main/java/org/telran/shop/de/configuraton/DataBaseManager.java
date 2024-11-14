package org.telran.shop.de.configuraton;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;

//@Component
@Deprecated
public class DataBaseManager {

    @Value("${database.url:}")
    private String dataBaseUrl;
    @Value("${database.name:}")
    private String dataBaseName;
    @Value("${database.user:}")
    private String userName;
    @Value("${database.password:}")
    private String password;

    private Connection connection;

    public DataBaseManager() {
       //
    }

    public Connection getConnection() {
        if (connection == null) {
            createConnection();
        }

        return connection;
    }

    @PostConstruct
    private void createConnection() {
        try {
            String connString = "jdbc:mysql://" + dataBaseUrl + "/" + dataBaseName;
            connection = DriverManager.getConnection(connString, userName, password);
        } catch (Exception e) {
            connection = null;
        }
    }
}
