package com.project.databases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component("sql")
public class SQLConnector {

    private String username;
    private String password;
    private String url;
    private String database;

    public SQLConnector() {
    }

    @Autowired
    public void setUsername(@Value("${jdbc.username}") String username) {
        this.username = username;
    }

    @Autowired
    public void setPassword(@Value("${jdbc.password}") String password) {
        this.password = password;
    }

    @Autowired
    public void setUrl(@Value("${jdbc.url}") String url) {
        this.url = url;
    }

    @Autowired
    public void setDatabase(@Value("${jdbc.database}") String database) {
        this.database = database;
    }

    @Override
    public String toString() {
        return "SQLConnector{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    private DriverManagerDataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    @PostConstruct
    public void open() {
        System.out.println("Create connection to " + url + " database");
        dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
    }

    @PreDestroy
    public void close() throws SQLException {
        System.out.println("Close " + url + " database connection");
        Connection connection = dataSource.getConnection();
        connection.close();
    }

}
