package db;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author yoka
 */
public class DBconnect {

    private static DBconnect dbc;
    private Connection conn;

    private DBconnect() {

    }

    public static DBconnect getInstance() {
        if (dbc == null) {
            dbc = new DBconnect();
        }
        return dbc;
    }

    public Connection getconn() {
        try {
            String url = "jdbc:mysql://localhost:3306/web_project";
            Properties prop = new Properties();
            prop.setProperty("user", "root");
            prop.setProperty("password", "root");
            System.out.println("jdbc");
            Driver d = new com.mysql.jdbc.Driver();
            System.out.println("driver");

            conn = (Connection) d.connect(url, prop);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conn;
    }
}
