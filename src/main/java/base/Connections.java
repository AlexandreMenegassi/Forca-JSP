package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connections {

	public static String url = "jdbc:mysql://localhost:3306/jdbc_forca";
	public static String usuario = "root";
	public static String senha = "";

	public static Connection openConnection() throws SQLException {
		return (Connection) DriverManager.getConnection(url, usuario, senha);
	}

}