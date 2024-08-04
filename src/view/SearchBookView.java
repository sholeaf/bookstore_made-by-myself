package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.BookController;
import model.dto.BookDTO;

public class SearchBookView {
	public SearchBookView() {
		Scanner sc = new Scanner(System.in);
		BookController controller = new BookController();
		
		while(true) {
			System.out.print("검색할 책 제목을 입력해 주세요 : ");
			String book_name = sc.nextLine();
			ArrayList<BookDTO> result = controller.bookSearch(book_name);
			
			if(result==null) {
				System.out.println("검색하신 책의 내용이 없습니다.");
			}
			else {
				for(BookDTO book:result)  {
					System.out.printf("%d번 / %s / %d / %s / %s / %s \n",
							book.getBook_id(),book.getBook_name(),book.getBook_price(),book.getBook_author(),
							book.getBook_publisher(),book.getBook_date());
				}
				
				System.out.println("===========================");
				System.out.print("찾으시는 책 번호를 입력해주세요 : ");
				int book_id = sc.nextInt();
				controller.selectBook(book_id);
				sc.nextLine();
				new BookOrderView();
			}
		}
		
	}
}
