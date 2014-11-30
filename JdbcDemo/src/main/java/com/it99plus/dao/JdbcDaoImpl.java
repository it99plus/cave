package com.it99plus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.it99plus.model.Staff;

@Component
public class JdbcDaoImpl {

	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate = new JdbcTemplate();

	public Staff getStaff(int staffId) {
		Connection conn = null;
		// String url = "jdbc:mysql://localhost:3306/zoodb";
		try {
			// Class.forName("com.mysql.jdbc.Driver").newInstance();
			// conn = DriverManager.getConnection(url, "root", "4321");
			conn = dataSource.getConnection();

			PreparedStatement ps = conn
					.prepareStatement("Select * From staff where staff_id = ?");
			ps.setInt(1, staffId);

			Staff staff = null;
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				staff = new Staff(staffId, rs.getString("name"));
			}
			rs.close();
			ps.close();
			return staff;
		} catch (SQLException e) {
			throw new RuntimeException();
		} finally {
			  try {
				conn.close();
			  } catch (SQLException e) {}
		}
	}
	
	
	@SuppressWarnings("deprecation")
	public int getStaffCount() {
		String sql = "SELECT COUNT(*) FROM STAFF";
//		jdbcTemplate.setDataSource(getDataSource());  
		// set the DataSource in jdbcTemplate to this.dataSource
		
		Integer integer = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM STAFF", Integer.class);
		return integer.intValue();
		
		
		// return jdbcTemplate.queryForInt(sql);
		// Depricated To fix it, replace the code with queryForObject(String, Class).
		// http://www.mkyong.com/spring/jdbctemplate-queryforint-is-deprecated/
		/* private boolean isUserExists(String username) {
		   		String sql = "SELECT count(*) FROM USERS WHERE username = ?";
				boolean result = false;
				int count = getJdbcTemplate().queryForObject(
		                        sql, new Object[] { username }, Integer.class);
				if (count > 0) {
					result = true;
				}
			return result;
		  }*/
	}
	

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		
//		this.dataSource = dataSource;
	}

	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}