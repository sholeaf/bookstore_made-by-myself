package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DBConnection;
import model.dto.UserDTO;

public class UserDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	public UserDAO() {
		conn = DBConnection.getConnection();
	}
	
	public UserDTO getUserByUserid(String user_id) {
		String sql = "select * from user where user_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user_id);
			
			rs = ps.executeQuery();
		
			if(rs.next()) {
				UserDTO user = new UserDTO(
						rs.getString("user_id"),
						rs.getString("user_name"),
						rs.getString("user_pw"),
						rs.getString("user_phone"),
						rs.getString("user_address"),
						rs.getInt("user_money"),
						rs.getInt("user_milage")
				);
				return user;
			}
		} catch (SQLException e) {
			System.out.println("예외발생 : "+e);
		}
		return null;
	}
	
	public boolean insertUser(UserDTO user) {
		String sql = "insert into user(user_id,user_name,user_pw,user_phone,user_address) values(?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getUser_id());
			ps.setString(2, user.getUser_name());
			ps.setString(3, user.getUser_pw());
			ps.setString(4, user.getUser_phone());
			ps.setString(5, user.getUser_address());
			
			int result = ps.executeUpdate();
			
			return result == 1;
		} catch (SQLException e) {
		}
		return false;
	}

	public long getUserMoney(String user_id) {
		String sql = "select user_money from user where user_id= ?";
		long money=0;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, user_id);
			
			rs=ps.executeQuery();
			
			if(rs.next()) {
				UserDTO user = new UserDTO(rs.getLong("user_money"));
				money = user.getUser_money();
				return money;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return money;
	}
	
	public int getUserMilage(String user_id) {
		String sql = "select user_milage from user where user_id=?";
		int milage=0;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, user_id);
			
			rs=ps.executeQuery();
			
			if(rs.next()) {
				UserDTO user = new UserDTO(rs.getInt("user_milage"));
				milage = user.getUser_milage();
				return milage;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return milage;
	}

	public boolean setUserMilage(String user_id,int user_milage) {
		String sql = "update user set user_milage=? where user_id=?";
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1,user_milage);
			ps.setString(2, user_id);
			
			int result = ps.executeUpdate();
			
			return result==1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean setUserMoney(String user_id,long user_money) {
		String sql = "update user set user_money=? where user_id=?";
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setLong(1, user_money);
			ps.setString(2, user_id);
			
			int result = ps.executeUpdate();
			
			return result==1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean change_pw(String user_id,String newpw) {
		String sql = "update user set user_pw=? where user_id=?";
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, newpw);
			ps.setString(2, user_id);
			
			int result = ps.executeUpdate();
			return result==1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean chage_addr(String user_id, String newaddr) {
		String sql = "update user set user_address=? where user_id =?";
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, newaddr);
			ps.setString(2, user_id);
			
			int result = ps.executeUpdate();
			return result==1;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean leaveID(String user_id) {
		String sql = "delete from user where user_id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, user_id);
			
			int result = ps.executeUpdate();
			
			return result==1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean plusMilage(String user_id) {
		String sql = "update user set user_milage = user_milage+100 where user_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user_id);
			int result = ps.executeUpdate();
			return result==1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
