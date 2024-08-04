package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import controller.LikelistController;
import controller.OrderController;
import controller.ReviewController;
import controller.UserController;
import model.Session;
import model.dto.LikelistDTO;
import model.dto.UserDTO;

public class UserInfoView {
	public UserInfoView() {
		Scanner sc = new Scanner(System.in);
		UserController uController = new UserController();
		LikelistController lController = new LikelistController();
		OrderController oController = new OrderController();
		ReviewController rController = new ReviewController();
		
		String user_id = (String) Session.getData("loginUser");
		HashMap<String, Object> datas = uController.getDetail(user_id);

		UserDTO user = (UserDTO) datas.get("user");
		System.out.print("비밀번호를 입력 해주세요 : ");
		String user_pw = sc.next();
		if (user.getUser_pw().equals(user_pw)) {
			while (true) {
				System.out.println(
						"1. 비밀번호 수정\n2. 주소 수정\n3. 보유금 추가\n4. 마일리지 확인" + "\n5. 찜 목록보기\n6. 구매내역 보기\n7. 회원 탈퇴\n8. 돌아 가기");
				int choice = sc.nextInt();

				if (choice == 8) {
					new MainView();
				}
				switch (choice) {
				case 1:
					sc = new Scanner(System.in);
					System.out.print("새로운 비밀번호를 입력하세요 : ");
					String newpw = sc.nextLine();
					System.out.print("비밀번호 확인을 위해 다시 입력해 주세요 : ");
					String check_newpw = sc.next();
					if (newpw.equals(check_newpw)) {
						uController.change_pw(user_id, newpw);
						System.out.println("비밀번호가 수정됬습니다!");
					} else {
						System.out.println("비밀번호가 일치하지 않습니다.");
					}
					break;

				case 2:
					System.out.print("새로운 주소를 입력해 주세요 : ");
					sc.nextLine();// 앞에 입력한 숫자 2+<Enter>로 이전문자열까지 반환하게 되므로 사용
					String newaddr = sc.nextLine();

					boolean flag = uController.change_addr(user_id, newaddr);
					if (flag == true) {
						System.out.println("새로운 주소로 변경되었습니다!!");
					} else {
						System.out.println("주소 변경에 실패했습니다.");
					}
					break;

				case 3:
					long user_money = uController.getUserMoney(user_id);
					System.out.printf("현재 %s님의 보유금은 ' %d ' 원입니다.\n", user.getUser_name(), user_money);
					System.out.print("추가하실 보유금을 입력해 주세요 : ");
					long addMoney = sc.nextInt();
					long plusMoney = user_money + addMoney;
					uController.setUserMoney(user_id, plusMoney);
					System.out.printf("현재 %s님의 보유금은 ' %d ' 원 입니다.\n", user.getUser_name(), plusMoney);
					break;

				case 4:
					int user_milage = uController.getUserMilage(user_id);
					System.out.printf("현재 %s 님의 마일리지는 %d 입니다. \n", user.getUser_name(), user_milage);
					break;

				case 5:
					System.out.println("찜 목록 입니다 .");
					try {
						ArrayList<LikelistDTO> result = lController.getLikeList(user_id);

						for (LikelistDTO list : result) {
							System.out.printf("찜 번호 : %d / 책 제목 : %s\n", list.getLikelist_id(), list.getBook_name());
							System.out.println("======================");
						}
					} catch (Exception e) {
						System.out.println("찜한게 없어요");
						break;
					}
					System.out.print("1. 찜 목록 삭제\n2. 돌아가기");
					int delete = sc.nextInt();
					if (delete == 1) {
						System.out.printf("삭제하실 찜 번호를 입력해 주세요 : ");
						int likelist_id = sc.nextInt();
						boolean flags = lController.deleteList(likelist_id);
						if (flags == true) {
							System.out.println("삭제되었습니다.");
							System.out.println("======================");
							break;
						} else {
							System.out.println("삭제 실패했습니다.");
							System.out.println("======================");
							break;
						}
					} else if (delete == 2) {
						break;
					} else {
						System.out.println("1 , 2 중 선택해주세요");
					}

				case 6:
					new OrderListView();
					break;

				case 7:
					System.out.print("비밀번호를 입력 해주세요 : ");
					String userpw = sc.next();
					if (user.getUser_pw().equals(userpw)) {
						rController.deleteReview(user_id);
						lController.deleteList(user_id);
						oController.deleteOrder(user_id);
						uController.leaveId(user_id);
						System.out.println(user_id+"님 계정이 삭제되었습니다.");
						Session.setData("loginUser", null);
						System.exit(0);	
					}
					
					else {
						System.out.println("비밀번호가 틀렸습니다. 다시 확인해 주세요");
						new MainView();
					}
				}
			}
		}
	}
}
