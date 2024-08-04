package view;

import java.util.Scanner;

import controller.UserController;
import model.Session;

public class LoginView {
	public LoginView() {
		Scanner sc = new Scanner(System.in);
		UserController controller = new UserController();
		System.out.println("로그인 페이지 입니다!");
		System.out.print("아이디 : ");
		String userid = sc.next();
		System.out.print("비밀번호 : ");
		String userpw = sc.next();
		
		if(controller.login(userid,userpw)) {
			System.out.println(Session.getData("loginUser")+"님 로그인에 성공했습니다!");
			new MainView();
		}
		else {
			System.out.println("로그인 실패 아디와 비밀번호를 확인 후 다시 시도해주세요!");
		}
		
	}
}
