package model.dao;

import model.DBConnection;
import model.Session;
import model.dto.LikelistDTO;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LikelistDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	public LikelistDAO() {
		conn = DBConnection.getConnection();
	}

	public boolean addList() {
		String user_id = (String) Session.getData("loginUser");
		int book_id = (int) Session.getData("selectBook");

		String sql = "insert into likelist(user_id,book_id) values(?,?)";

		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, user_id);
			ps.setInt(2, book_id);

			int result = ps.executeUpdate();

			return result == 1;

		} catch (SQLException e) {
			System.out.println("찜목록 추가에 실패 했습니다.");
		}
		return false;
	}

	public ArrayList<LikelistDTO> getLikeList(String user_id) {
		String sql = "select l.*,b.book_name,b.book_price" + " from likelist l" + " inner join book b"
				+ " on l.book_id = b.book_id" + " where user_id=?";
		ArrayList<LikelistDTO> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user_id);

			rs = ps.executeQuery();

			while (rs.next()) {
				LikelistDTO likelist = new LikelistDTO(rs.getInt("likelist_id"), rs.getString("user_id"),
						rs.getInt("book_id"), rs.getString("book_name"), rs.getInt("book_price"));
				list.add(likelist);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (list.size() == 0) {
			return null;
		} else {
			return list;
		}
	}

	public boolean deleteList(int likelist_id) {
		String sql = "delete from likelist where likelist_id=" + likelist_id;
		try {
			ps = conn.prepareStatement(sql);
			int result = ps.executeUpdate();
			return result == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean deleteList(String user_id) {
		String sql = "delete from likelist where user_id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user_id);
			int result = ps.executeUpdate();
			return result == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
}
