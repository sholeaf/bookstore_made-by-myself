package view;

import java.util.Scanner;

import model.Session;
import controller.UserController;
import controller.BookController;
import controller.OrderController;

public class OrderView {
	//책구매를 하기위한 view
	public OrderView() {
		Scanner sc = new Scanner(System.in);
		UserController uController = new UserController();
		BookController bController = new BookController();
		OrderController oController = new OrderController();
		String user_id = (String)Session.getData("loginUser");
		int book_id = (int)Session.getData("selectBook");
		
		int book_price = bController.getPrice(book_id);
		long uMoney = uController.getUserMoney(user_id);
		int uMilage = uController.getUserMilage(user_id);
		
		while (true) {
			System.out.println("=============================");
			System.out.println("1. 보유금(+마일리지)으로 결제하기\n2. 보유금으로 결제하기\n3. 결제 취소하기");
			int choice = sc.nextInt();

			if (choice == 3) {
				//세션에 저장된 선택한 책의 값을 지우고 메인view로 이동
				System.out.println("결제가 취소 되었습니다!");
				Session.setData("selectBook", null);
				new MainView();
			}
			else if(choice == 1) {
				
				System.out.print("사용하실 마일리지 금액을 입력해주세요 : ");
				int milage = sc.nextInt();
				
				if(milage>uMilage) {
					System.out.printf("마일리지 금액이 적습니다. 현재 보유하고 있는 마일리지( %d )",uMilage);
				}
				else {
					int price =book_price-milage;
					int user_milage = uMilage-milage;
					
					uController.setUserMilage(user_id,user_milage);
					
					System.out.printf("마일리지를 적용한 책 가격은 '%d 원' 입니다.\n",price);
					if(price>uMoney) {
						//마일리지 돌려주는 함수 만들기
						System.out.println("금액이 모자랍니다. 보유금을 확인해주세요.");
						uController.setUserMilage(user_id,uMilage);
						Session.setData("selectBook", null);
						new MainView();
					}
					else {
						long user_money = uMoney-price;
						uController.setUserMoney(user_id,user_money);
						
						System.out.printf("책을 수령할 주소를 입력해 주세요 : ");
						sc.nextLine();
						String order_address = sc.nextLine();
						
						oController.addOrderList(user_id,book_id,order_address);
						System.out.printf("결제가 완료되었습니다.\n남은 금액 : %d\n",user_money);
						Session.setData("selectBook", null);
						new MainView();
					}
				}
			}
			else if(choice == 2) {
				System.out.printf("보유금액 %d 입니다.\n",uMoney);
				if(book_price>uMoney) {
					System.out.println("보유금액이 모자라요~ 충전하고 결제해 주세요");
					new MainView();
				}
				else {
					long user_money = uMoney-book_price;
					uController.setUserMoney(user_id,user_money);
					System.out.printf("책을 수령할 주소를 입력해 주세요 : ");
					sc.nextLine();
					String order_address = sc.nextLine();
					oController.addOrderList(user_id,book_id,order_address);
					
					System.out.printf("결제가 완료되었습니다. 남은 금액 : %d\n",user_money);
					System.out.println("감사합니다.");
					
					Session.setData("selectBook", null);
					
					new MainView();
				}
			}
			else {
				System.out.println("보기중에 골라주세요.");
			}
		}
	}
}
