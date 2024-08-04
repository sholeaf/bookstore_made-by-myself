package view;

import java.util.Scanner;

import model.Session;

public class MainView {
	public MainView() {
		System.out.println("메인 페이지 입니다!");
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("============================================");
			System.out.println("1. 책 구경하기\n2. 회원정보 확인 및 수정\n3. 로그아웃");
			System.out.print("원하시는 옵션을 선택하세요 : ");
			int choice = sc.nextInt();
			if(choice == 1) {
				new BookView();
			}
			else if(choice == 2) {
				new UserInfoView();
			}
			else if(choice ==3) {
				System.out.println(Session.getData("loginUser")+"님 로그아웃 되었습니다!");
				System.out.println("프로그램을 종료하겠습니다.");
				Session.setData("loginUser", null);
				System.exit(0);
			}
			else
				System.out.println("다시 입력해주세요!");
		}
	}
}
