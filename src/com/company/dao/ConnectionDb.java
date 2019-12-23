package com.company.dao;

import com.company.consts.Const;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class  ConnectionDb extends Const {
    private static Connection dbConnection;

    public static Connection getDbConnection() throws ClassNotFoundException, SQLException {
        System.out.println("dsfh");
        String connectionString = "jdbc:mysql://localhost:3306/catworld" +
                "?verifyServerCertificate=false" +
                "&useSSL=false" +
                "&requireSSL=false" +
                "&useLegacyDatetimeCode=false" +
                "&amp" +
                "&serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbuser, dbpass);
        return dbConnection;
    }
}
