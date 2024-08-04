package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.BookController;
import model.dto.BookDTO;

public class BookView {
	public BookView() {
		BookController controller = new BookController();
		ArrayList<BookDTO> result= controller.getBookList();
		Scanner sc =new Scanner(System.in);
		
		System.out.println("============================================");
		System.out.println("Best 20의 책 목록입니다.");
		System.out.println("책번호 / 제목 / 가격 / 글쓴이 / 출판사 / 출시일");
		
		if(result==null) {
			System.out.println("등록된 책이 없습니다!");
		}
		else {
			for(BookDTO book : result) {
				System.out.printf("%d번 / %s / %d / %s / %s / %s \n",
						book.getBook_id(),book.getBook_name(),book.getBook_price(),book.getBook_author(),
						book.getBook_publisher(),book.getBook_date());
			}
		}
		System.out.println("============================================");
		while(true) {
			System.out.println("1. 책 검색하기\n2. 돌아가기");
			try {
				int choice= sc.nextInt();
				if(choice==1) {
					new SearchBookView();
				}
				else if(choice==2) {
					new MainView();
				}
				else {
					System.out.println();
				}
			} catch (Exception e) {
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
}
