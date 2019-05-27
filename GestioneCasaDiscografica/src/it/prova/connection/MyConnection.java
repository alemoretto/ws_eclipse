package it.prova.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {

	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static final String CONNECT_STR = "jdbc:mysql://127.0.0.1:3306/gestionecasadiscografica?user=root&password=root";

	// per oracle XE (occhio che nelle insert servirebbero le sequence)
	// private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	// private static final String CONNECT_STR =
	// "jdbc:oracle:thin:@localhost:1521:XE";

	public static Connection getConnection() {

		Connection connection = null;
		try {

			Class.forName(DRIVER_NAME);
			connection = DriverManager.getConnection(CONNECT_STR);
			//per oracle 
			// c = DriverManager.getConnection(CONNECT_STR,"vostrausername","vostrapassword");

		} catch (Exception ex) {

			ex.printStackTrace();
		}

		return connection;
	} // end get connection.
}
