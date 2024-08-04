package model.dto;

public class ReviewDTO {
	private int review_id;
	private String review_text;
	private String review_date;
	private double review_score;
	private int book_id;
	private String user_id;
	private double avg_score;

	public ReviewDTO() {
	}
	
	public ReviewDTO(int book_id, String user_id) {
		this.book_id = book_id;
		this.user_id = user_id;
	}

	public ReviewDTO(int review_id, String review_text, String review_date, double review_score, int book_id,
			String user_id) {
		this.review_id = review_id;
		this.review_text = review_text;
		this.review_date = review_date;
		this.review_score = review_score;
		this.book_id = book_id;
		this.user_id = user_id;
	}
	public ReviewDTO(double avg_score) {
		this.avg_score = avg_score;
	}
	
	
	public int getBook_id() {
		return book_id;
	}

	public String getReview_date() {
		return review_date;
	}

	public int getReview_id() {
		return review_id;
	}

	public double getReview_score() {
		return review_score;
	}

	public String getReview_text() {
		return review_text;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public void setReview_date(String review_date) {
		this.review_date = review_date;
	}

	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}

	public void setReview_score(double review_score) {
		this.review_score = review_score;
	}

	public void setReview_text(String review_text) {
		this.review_text = review_text;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
}
