package com.company.dao;

import com.company.consts.Const;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDb {
    private static Connection dbConnection;

    public static Connection getDbConnection() throws ClassNotFoundException, SQLException {
        if (dbConnection != null && !dbConnection.isClosed()) return dbConnection;
        String connectionString = "jdbc:mysql://localhost:3306/catworld" +
                "?verifyServerCertificate=false" +
                "&useSSL=false" +
                "&requireSSL=false" +
                "&useLegacyDatetimeCode=false" +
                "&amp" +
                "&serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, Const.DBUSER, Const.DBPASS);
        return dbConnection;
    }
}
