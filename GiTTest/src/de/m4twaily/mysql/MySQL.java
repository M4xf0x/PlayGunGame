package de.m4twaily.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL {

	public static String host = "localhost";
	public static String port = "3306";
	public static String database = "Plugin";
	public static String username = "test";
	public static String password = "nozLWfstbYU1uikG";
	public static Connection con;

	public static void connect() {
		if (!isConnected()) {
			try {
				con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username,
						password);

				System.out.println(" ");
				System.out.println("MySQL connectet");
				System.out.println(" ");

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void disconnect() {
		if (isConnected()) {
			try {
				con.close();

				System.out.println(" ");
				System.out.println("MySQL disconnectet");
				System.out.println(" ");

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static boolean isConnected() {
		return (con == null ? false : true);
	}

	public static void update(String qry) {
		try {
			PreparedStatement ps = con.prepareStatement(qry);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ResultSet getResult(String qry) {
		try {
			PreparedStatement ps = con.prepareStatement(qry);

			return ps.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static Connection getConnection() {
		return con;

	}
}
