package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DBConnection;
import model.dto.OrderDTO;

public class OrderDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	public OrderDAO(){
		conn = DBConnection.getConnection();
	}

	public boolean addOrderList(String user_id, int book_id,String order_address) {
		String sql ="insert into `order`(order_address,order_date,user_id,book_id) values(?,now(),?,?)";
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,order_address);
			ps.setString(2, user_id);
			ps.setInt(3, book_id);
			
			int result=ps.executeUpdate();
			
			return result==1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public ArrayList<OrderDTO> getOrderList(String user_id) {
		String sql = "select order_num,order_address,order_date,b.book_name,b.book_id,b.book_price"
				+ " from `order` o"
				+ " inner join book b"
				+ " on o.book_id = b.book_id"
				+ " where user_id=?";
		ArrayList<OrderDTO> list = new ArrayList<>();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, user_id);
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				OrderDTO orderlist = new OrderDTO(
						rs.getInt("order_num"),
						rs.getString("order_address"),
						rs.getString("order_date"),
						rs.getString("book_name"),
						rs.getInt("book_id"),
						rs.getInt("book_price")
						);
				list.add(orderlist);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(list.size()==0){
			return null;
		}
		else {
			return list;
		}
	}

	public boolean deleteOrder(String user_id) {
		String sql ="delete from `order` where user_id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user_id);
			int result=ps.executeUpdate();
			return result==1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
