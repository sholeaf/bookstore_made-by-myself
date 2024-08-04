package model.dto;

public class LikelistDTO {
	private int likelist_id;
	private String user_id;
	private int book_id;
	private String book_name;
	private int book_price;
	
	public LikelistDTO() {}
	
	public LikelistDTO(int likelist_id, String user_id, int book_id) {
		this.likelist_id = likelist_id;
		this.user_id = user_id;
		this.book_id = book_id;
	}
	public LikelistDTO(int likelist_id, String user_id, int book_id,String book_name,int book_price) {
		this.likelist_id = likelist_id;
		this.user_id = user_id;
		this.book_id = book_id;
		this.book_name = book_name;
		this.book_price = book_price;
	}
	
	public LikelistDTO(String user_id,int book_id) {
		this.user_id = user_id;
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public int getBook_price() {
		return book_price;
	}
	public void setBook_price(int book_price) {
		this.book_price = book_price;
	}
	
	public int getBook_id() {
		return book_id;
	}
	public int getLikelist_id() {
		return likelist_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public void setLikelist_id(int likelist_id) {
		this.likelist_id = likelist_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
}
