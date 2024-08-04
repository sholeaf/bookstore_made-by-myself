package view;

import java.util.Scanner;
import controller.UserController;
import model.dto.UserDTO;

public class JoinView {
	public JoinView() {
		Scanner sc = new Scanner(System.in);
		UserController controller = new UserController();
		System.out.println("======회원가입 페이지 입니다======");
		System.out.print("아이디 : ");
		String user_id = sc.nextLine();
		if(controller.checkId(user_id)) {
			System.out.print("비밀번호 : ");
			String user_pw = sc.nextLine();
			System.out.print("비밀번호 확인 : ");
			String userpw_re = sc.nextLine();
			if(user_pw.equals(userpw_re)) {
				System.out.print("이름 : ");
				String user_name = sc.nextLine();
				System.out.print("핸드폰 번호 : ");
				String user_phone = sc.nextLine();
				System.out.print("주소 : ");
				String user_address = sc.nextLine();
				UserDTO user = new UserDTO(user_id, user_name, user_pw,
						user_phone, user_address);

				if(controller.join(user)) {
					System.out.println("회원가입 성공!");
				}
				else {
					System.out.println("회원가입 실패... / 다음에 다시 시도해 주세요~");
				}
			}
			else {
				System.out.println("비밀번호 확인을 다시 해주세요!");
			}
		}
		else {
			System.out.println("중복된 아이디가 있습니다!");
		}
	}
}
