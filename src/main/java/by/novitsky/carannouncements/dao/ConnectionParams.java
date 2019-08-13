package by.novitsky.carannouncements.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class ConnectionParams {

    public static final String DB_URL = "jdbc:postgresql://localhost:5432/carsforsale";
    public static final String USER = "postgres";
    public static final String PASS = "root";
    public static final String URL_PARAMS = DB_URL + "?user=" + USER +  "&password=" + PASS;

}
