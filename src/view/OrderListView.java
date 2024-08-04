package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.OrderController;
import controller.ReviewController;
import controller.UserController;
import model.Session;
import model.dto.BookDTO;
import model.dto.OrderDTO;
import model.dto.ReviewDTO;

public class OrderListView {
	public OrderListView() {
		OrderController oController = new OrderController();
		ReviewController rController = new ReviewController();
		UserController uController = new UserController();
		Scanner sc = new Scanner(System.in);
		

		String user_id = (String) Session.getData("loginUser");
		ArrayList<OrderDTO> result = oController.getOrderList(user_id);
		ArrayList<Integer> list = new ArrayList<>();

		System.out.println("현재 구매 내역입니다.");
		System.out.println("=================");

		try {
			for (OrderDTO order : result) {
				System.out.printf("주문번호 : %d \n 주소 : %s [%s(주문날짜)]\n책 이름(%d) : %s / 가격 : %d\n", order.getOrder_num(),
						order.getOrder_address(), order.getOrder_date(), order.getBook_id(), order.getBook_name(),
						order.getBook_price());
				System.out.println("===================");
				list.add(order.getBook_id());
			}
		} catch (Exception e) {
			System.out.println("구매내역이 없습니다!");
			new MainView();
		}
		while (true) {
			System.out.print("1. 리뷰 작성하기 \n2. 돌아가기\n");
			int choice = sc.nextInt();
			if (choice == 1) {
				boolean flag=false;
				
				System.out.println("책 번호를 선택해 주세요 : ");
				int selectBook_id = sc.nextInt();
				if(rController.checkReview(selectBook_id, user_id)==true) {
					for(int i=0;i<list.size();i++) {
						if(list.get(i).equals(selectBook_id)) {
							flag = true;
							break;
						}
					}
					if(flag==true) {
						System.out.println("평점을 입력해 주세요(10~0.00) : ");
						double score = sc.nextDouble();

						if (score <= 10 && score >= 0) {
							System.out.println("리뷰 내용을 입력해 주세요 : ");
							sc.nextLine();
							String text = sc.nextLine();
							rController.setReview(text, score, selectBook_id, user_id);
							uController.plusMilage(user_id);
						} else {
							System.out.println("0~10까지만 입력해주세요.");
							break;
						}
					}
					else {
						System.out.println("구매목록에 있는 책번호를 입력해 주세요!");
					}
				}
				else {
					System.out.println("이미 리뷰를 작성한 책입니다.");
				}
				
			} else if (choice == 2) {
				new UserInfoView();
			} else {
				System.out.println("잘못입력했습니다.");
			}
		}
	}
}