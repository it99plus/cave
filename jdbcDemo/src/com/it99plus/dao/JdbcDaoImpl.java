package com.it99plus.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.it99plus.model.Staff;

public class JdbcDaoImpl {

	public Staff getStaff(int staffId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String url = "jdbc:mysql://localhost:3306/zoodb";
		Staff staff = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, "root", "4321");
			ps = conn.prepareStatement("Select * From staff where staff_id = ?");
			ps.setInt(1, staffId);
			rs = ps.executeQuery();

			if (rs.next()) {
				staff = new Staff(staffId, rs.getString("name"));
			}

		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				rs.close();
				ps.close();
				return staff;
			} catch (SQLException e) {
			}
		}
		return staff;

	}

}
