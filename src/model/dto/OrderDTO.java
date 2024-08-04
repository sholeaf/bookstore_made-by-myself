package model.dto;

public class OrderDTO {
	private int order_num;
	private String order_address;
	private String order_date;
	private String user_id;
	private int book_id;
	private String book_name;
	private int book_price;
	
	public OrderDTO() {}
	
	public OrderDTO(int order_num,String order_address, String order_date,
			String book_name,int book_id,int book_price) {
		this.order_num = order_num;
		this.order_address = order_address;
		this.order_date = order_date;
		this.book_name = book_name;
		this.book_id = book_id;
		this.book_price = book_price;
	}
	
	public String getBook_name() {
		return book_name;
	}
	
	public int getBook_id() {
		return book_id;
	}
	public int getBook_price() {
		return book_price;
	}
	public String getOrder_address() {
		return order_address;
	}
	public String getOrder_date() {
		return order_date;
	}
	public int getOrder_num() {
		return order_num;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public void setBook_price(int book_price) {
		this.book_price = book_price;
	}
	public void setOrder_address(String order_address) {
		this.order_address = order_address;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
}
