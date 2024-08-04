package controller;

import java.util.ArrayList;

import model.Session;
import model.dao.BookDAO;
import model.dto.BookDTO;

public class BookController {
	public ArrayList<BookDTO> getBookList() {
		BookDAO bookDao = new BookDAO();
		return bookDao.getBookList();
	}
	
	public ArrayList<BookDTO> bookSearch(String book_name) {
		BookDAO bookDao = new BookDAO();
		return bookDao.bookSearch(book_name);
	}

	public boolean selectBook(int book_id) {
		BookDAO bookDao = new BookDAO();
		BookDTO book = bookDao.getBook_id(book_id);
		if(book != null) {
			Session.setData("selectBook", book.getBook_id());
			return true;
		}
		return false;
	}

	public int getPrice(int book_id) {
		BookDAO bookDao = new BookDAO();
		return bookDao.getBook_price(book_id);
	}
	

}
