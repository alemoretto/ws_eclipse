package it.prova.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {

	private static String DRIVER_NAME = "com.mysql.jdbc.Driver";
	//private static String CONNECT_STR = "jdbc:mysql://localhost:3306/abitante?user=root&password=root";
	private static final String CONNECT_STR = "jdbc:mysql://127.0.0.1:3306/negozi?user=root&password=root";

	public static Connection getConnection() {

		Connection c = null;
		try {

			Class.forName(DRIVER_NAME);
			c = DriverManager.getConnection(CONNECT_STR);

		} catch (Exception ex) {

			ex.printStackTrace();
		}

		return c;
	} // end get connection.
}
