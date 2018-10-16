package de.m4twaily.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class Points {

	public static boolean isUserExisting(UUID uuid) {
		try {
			PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT Value FROM points WHERE UUID = ?");
			ps.setString(1, uuid.toString());
			ResultSet rs = ps.executeQuery();

			return rs.next();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void update(UUID uuid, int amount, boolean remove) {
		try {

			int points = getPoints(uuid);

			if (remove) {
				amount -= points;
			} else {
				amount += points;
			}

			if (isUserExisting(uuid)) {

				PreparedStatement ps = MySQL.getConnection()
						.prepareStatement("UPDATE points SET Value = ? WHERE UUID = ?");

				ps.setString(1, uuid.toString());
				ps.setInt(2, amount);
				ps.executeUpdate();

			} else {

				PreparedStatement ps = MySQL.getConnection()
						.prepareStatement("INSERT INTO points (UUID, Value) VALUES (?,?)");

				ps.setString(1, uuid.toString());
				ps.setInt(2, amount);
				ps.executeUpdate();

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void delete(UUID uuid) {
		try {
			if (isUserExisting(uuid)) {
				PreparedStatement ps = MySQL.getConnection().prepareStatement("DELETE * FROM points WHERE UUID = ?");

				ps.setString(1, uuid.toString());
				ps.executeUpdate();

			} else {
				System.out.println(" ");
				System.out.println("Spieler nicht vorhanden");
				System.out.println(" ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Integer getPoints(UUID uuid) {
		try {

			PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT Value FROM points WHERE UUID = ?");

			ps.setString(1, uuid.toString());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				return rs.getInt("Value");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;

	}

	public static void addCoins(UUID uuid, int value) {
		try {
			int currentValue = getPoints(uuid);

			PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE points SET Value = ? WHERE UUID = ?");

			ps.setInt(1, currentValue + value);
			ps.setString(2, uuid.toString());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
