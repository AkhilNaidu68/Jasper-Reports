package com.exalt;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConnectionUtils {

	public static Connection getConnection() throws SQLException,
    ClassNotFoundException {

return (Connection) MySQLConnUtils.getMySQLConnection();
}

//
// Test Connection ...
//
public static void main(String[] args) throws SQLException,
    ClassNotFoundException {

System.out.println("Get connection ... ");

// Get a Connection object
Connection conn = ConnectionUtils.getConnection();

System.out.println("Get connection " + conn);

System.out.println("Done!");
}
}
