package controller;

import java.util.ArrayList;

import model.Session;
import model.dao.ReviewDAO;
import model.dto.ReviewDTO;

public class ReviewController {
	
	public ArrayList<ReviewDTO> reviewList(int book_id) {
		ReviewDAO reviewDao = new ReviewDAO();
		return reviewDao.getReviewList(book_id);
	}
	
	public double avg_rvScore(int book_id) {
		ReviewDAO reviewDao = new ReviewDAO();
		return reviewDao.get_avg_score(book_id);
	}

	public boolean setReview(String text, double score, int selectBook_id, String user_id) {
		ReviewDAO reviewDao = new ReviewDAO();
		return reviewDao.setReview(text,score,selectBook_id,user_id);
		
	}
	public boolean deleteReview(String user_id) {
		ReviewDAO reviewDao = new ReviewDAO();
		return reviewDao.delteReview(user_id);
	}
	public boolean checkReview(int book_id, String user_id) {
		ReviewDAO reviewDao = new ReviewDAO();
		return reviewDao.checkReview(book_id, user_id);
	}
	
}
