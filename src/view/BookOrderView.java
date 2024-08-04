package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.LikelistController;
import controller.ReviewController;
import model.Session;
import model.dto.ReviewDTO;

public class BookOrderView {
	public BookOrderView() {
		ReviewController reviewController = new ReviewController();
		LikelistController likelistController = new LikelistController();

		Scanner sc = new Scanner(System.in);
		
		System.out.println("===========================");
		while(true) {
			System.out.println("1. 리뷰 보기\n2. 찜 하기\n3. 구매 하기 \n4. 메인으로 돌아가기");
			int choice = sc.nextInt();
			if(choice==4) {
				Session.setData("selectBook", null);
				new MainView();
			}
			switch(choice) {
			case 1:
				int book_id = (int)Session.getData("selectBook");
				double avg = reviewController.avg_rvScore(book_id);
				System.out.printf("책의 평균 평점 : %.2f\n",avg);
				System.out.println("===========================");
				ArrayList<ReviewDTO> result = reviewController.reviewList(book_id);
				if(result==null) {
					System.out.println("등록된 리뷰가 없습니다.");
				}else {
					for(ReviewDTO review : result) {
						System.out.printf("%d 번 리뷰(작성자 : %s / 작성일 : %s / 평점 : %.2f) : %s\n",review.getReview_id(),
								review.getUser_id(),review.getReview_date(),review.getReview_score(),review.getReview_text());
						System.out.println("===========================");
					}
				}
				break;
			case 2:
				likelistController.addList();
				System.out.println("찜목록에 책이 추가 되었어요!");
				break;
			case 3:
				new OrderView();
				break;
			}
		}
	}
}
