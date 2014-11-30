package com.it99plus.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.it99plus.model.Staff;

@Component
public class JdbcDaoImpl {
	
	@Autowired
	private DataSource dataSource;

	public Staff getStaff(int staffId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// String url = "jdbc:mysql://localhost:3306/zoodb";
		Staff staff = null;
		try {
		//	Class.forName("com.mysql.jdbc.Driver").newInstance();
		//	conn = DriverManager.getConnection(url, "root", "4321");
			conn = dataSource.getConnection();
			ps = conn.prepareStatement("Select * From staff where staff_id = ?");
			ps.setInt(1, staffId);
			rs = ps.executeQuery();

			if (rs.next()) {
				staff = new Staff(staffId, rs.getString("name"));
			}
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


	public DataSource getDataSource() {
		return dataSource;
	}


	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}