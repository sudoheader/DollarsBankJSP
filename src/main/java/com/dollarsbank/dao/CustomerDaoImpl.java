package com.dollarsbank.dao;

import com.dollarsbank.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

	public static Connection getConnection() {

		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/dollarsbank_db?serverTimezone=EST5EDT","root","root" );
			return conn;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	@Override
	public int updateBalance(String userId, double balance) {
		try {
			Connection conn = getConnection();

			PreparedStatement pstmt =
					conn.prepareStatement("update account set balance=? where user_id=" +"'"+ userId+"'");
			pstmt.setDouble(1, balance);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(int id) {
		int status = 0;
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt =
					conn.prepareStatement("delete from user where id=?");
			pstmt.setInt(1, id);
			status = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int save(Customer cust) {
		try {
			Connection conn = getConnection();
			List<Customer> list = getAllAccounts();
			for (Customer customer : list) {
				if(cust.getUserId().equals(customer.getUserId())) {
					return 0;
				}
			}
			
			PreparedStatement pstmt =
					conn.prepareStatement("insert into account(name, address, contact, user_id, password, balance) values(?,?,?,?,?,?)");
			pstmt.setString(1, cust.getCustomer());
			pstmt.setString(2, cust.getAddress());
			pstmt.setString(3, cust.getContact());
			pstmt.setString(4, cust.getUserId());
			pstmt.setString(5, cust.getPassword());
			pstmt.setDouble(6, cust.getBalance());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Customer getCustomerById(int id) {
		Customer e = new Customer();
		try {
	            Connection conn = CustomerDaoImpl.getConnection();
	            PreparedStatement pstmt =
						conn.prepareStatement("select * from user where id=?");
	            pstmt.setInt(1,id);
	            ResultSet rs = pstmt.executeQuery();
	            conn.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	          
		return e;
	}

	@Override
	public List<Customer> getAllAccounts() {
		List<Customer> list = new ArrayList<Customer>();
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt =
					conn.prepareStatement("select * from account");
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				list.add(new Customer(rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getDouble(6)));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

	@Override
	public void saveHistory(String userId, String message) {
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt =
					conn.prepareStatement("insert into transactions(userid, history)values(?,?)");
			pstmt.setString(1, userId);
			pstmt.setString(2, message);
			pstmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public List<String> getHistory(String userId) {
		List<String> list = new ArrayList<>();
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt =
					conn.prepareStatement("select * from transaction_history where userid='" + userId + "'");
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				list.add(rs.getString(3));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return list;
	}
}
