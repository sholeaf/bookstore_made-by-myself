package model.dto;

public class BookDTO {
	private int book_id;
	private String book_name;
	private int book_price;
	private String book_info;
	private String book_author;
	private String book_publisher;
	private String book_date;
	
	
	public BookDTO() {}
	
	public BookDTO(int book_id,String book_name, int book_price,
			String book_author,String book_publisher,String book_date) {
		this.book_id = book_id;
		this.book_name = book_name;
		this.book_price = book_price;
		this.book_author = book_author;
		this.book_publisher = book_publisher;
		this.book_date = book_date;
	}
	
	public BookDTO(int book_price) {
		this.book_price = book_price;
	}
	
	public String getBook_author() {
		return book_author;
	}
	public String getBook_date() {
		return book_date;
	}
	public int getBook_id() {
		return book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public int getBook_price() {
		return book_price;
	}
	public String getBook_publisher() {
		return book_publisher;
	}
	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}
	public void setBook_date(String book_date) {
		this.book_date = book_date;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public void setBook_price(int book_price) {
		this.book_price = book_price;
	}
	public void setBook_publisher(String book_publisher) {
		this.book_publisher = book_publisher;
	}
}
