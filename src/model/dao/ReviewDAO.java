package model.dao;

import model.DBConnection;
import model.dto.ReviewDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReviewDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	int book_id;
	
	public ReviewDAO(){
		conn = DBConnection.getConnection();
	}
	public ArrayList<ReviewDTO> getReviewList(int book_id) {
		
		String sql = "select * from review where book_id=?";
		ArrayList<ReviewDTO> list = new ArrayList<>();
		
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, book_id);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				ReviewDTO reviewList = new ReviewDTO(
						rs.getInt("review_id"),
						rs.getString("review_text"),
						rs.getString("review_date"),
						rs.getDouble("review_score"),
						rs.getInt("book_id"),
						rs.getString("user_id")
						);
				list.add(reviewList);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(list.size()==0) {
			return null;
		}
		else {
			return list;
		}
	}
	public ArrayList<ReviewDTO> getReviewList() {
		
		String sql = "select * from review where user_id=?";
		ArrayList<ReviewDTO> list = new ArrayList<>();
		
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, book_id);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				ReviewDTO reviewList = new ReviewDTO(
						rs.getInt("review_id"),
						rs.getString("review_text"),
						rs.getString("review_date"),
						rs.getDouble("review_score"),
						rs.getInt("book_id"),
						rs.getString("user_id")
						);
				list.add(reviewList);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(list.size()==0) {
			return null;
		}
		else {
			return list;
		}
	}
	
	public double get_avg_score(int book_id) {
		String sql = "select avg(review_score) from review where book_id="+book_id;
		double result=0;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {
				result=rs.getDouble("avg(review_score)");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public boolean setReview(String text, double score, int selectBook_id, String user_id) {
		String sql = "insert into review(review_text,review_date,review_score,book_id,user_id)"
				+ " values(?,now(),?,?,?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, text);
			ps.setDouble(2, score);
			ps.setInt(3,selectBook_id);
			ps.setString(4, user_id);
			
			int result=ps.executeUpdate();
			return result==1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean delteReview(String user_id) {
		String sql = "delete from review where user_id =?";
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
	public boolean checkReview(int book_id, String user_id) {
		ArrayList<ReviewDTO> list = new ArrayList<>();
		
		boolean flag = false;
		
		String sql="select book_id,user_id from review where book_id=? and user_id =?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, book_id);
			ps.setString(2,user_id);
			rs=ps.executeQuery();
			while(rs.next()) {
				ReviewDTO reviewList = new ReviewDTO(
						rs.getInt("book_id"),
						rs.getString("user_id")
						);
				list.add(reviewList);
			}
			if(list.size()==0) {
				flag=true;
				return flag;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
