package jm.task.core.jdbc.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static final String URL = "jdbc:mysql://localhost:3306/userdb";
    private static final String USER = "root";
    private static final String PASSWORD = "6374985";
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration conf = new Configuration();
            conf.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/userdb");
            conf.setProperty("hibernate.connection.username", "root");
            conf.setProperty("hibernate.connection.password", "6374985");
            conf.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
            sessionFactory = conf.buildSessionFactory();
        }
        return sessionFactory;
    }
}
