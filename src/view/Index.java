package view;

import java.util.*;

public class Index {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("책 구매 프로젝트");
		
		while(true) {
			System.out.println("============================================");
			System.out.println("1.회원가입\n2.로그인\n3.프로그램 종료");
			int choice= sc.nextInt();
			if(choice==3) {
				System.out.println("프로그램을 종료하겠습니다! 다음에 또 오세요!");
				break;
			}
			switch (choice) {
			case 1 :
				new JoinView();
				break;
				
			case 2 :
				new LoginView();
				break;
			}
			
		}
	}
}
