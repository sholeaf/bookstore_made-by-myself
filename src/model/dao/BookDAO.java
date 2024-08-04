package model.dao;

import model.DBConnection;
import model.dto.BookDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	public BookDAO() {
		conn = DBConnection.getConnection();
	}

	public ArrayList<BookDTO> getBookList() {
		ArrayList<BookDTO> list = new ArrayList<>();
		String sql = "select * from book limit 20";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				BookDTO bookList = new BookDTO(rs.getInt("book_id"), rs.getString("book_name"), rs.getInt("book_price"),
						rs.getString("book_author"), rs.getString("book_publisher"), rs.getString("book_date"));

				list.add(bookList);
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

	public ArrayList<BookDTO> bookSearch(String book_name) {
		ArrayList<BookDTO> list = new ArrayList<>();
		String sql = "select * from book where book_name like '%" + book_name + "%'";

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				BookDTO bookList = new BookDTO(rs.getInt("book_id"), rs.getString("book_name"), rs.getInt("book_price"),
						rs.getString("book_author"), rs.getString("book_publisher"), rs.getString("book_date"));
				list.add(bookList);
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

	public BookDTO getBook_id(int book_id) {
		String sql = "select * from book where book_id=" + book_id;

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			if (rs.next()) {
				BookDTO book = new BookDTO(rs.getInt("book_id"), rs.getString("book_name"), rs.getInt("book_price"),
						rs.getString("book_author"), rs.getString("book_publisher"), rs.getString("book_date"));
				return book;
			}

		} catch (SQLException e) {

		}
		return null;
	}

	public int getBook_price(int book_id) {
		String sql= "select book_price from book where book_id="+book_id;
		int price=0;
		try {
			ps= conn.prepareStatement(sql);
			rs= ps.executeQuery();
			
			if(rs.next()) {
				BookDTO book = new BookDTO(rs.getInt("book_price"));
				price = book.getBook_price();
				return price;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return price;
	}
}
