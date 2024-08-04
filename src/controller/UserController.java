package controller;

import java.util.HashMap;

import model.Session;
import model.dao.UserDAO;
import model.dto.UserDTO;

public class UserController {
	public boolean checkId(String user_id) {
		UserDAO udao = new UserDAO();
		UserDTO user = udao.getUserByUserid(user_id);
		return user==null;
	}
	
	public boolean join(UserDTO user) {
		UserDAO udao = new UserDAO();
		return udao.insertUser(user);
	}
	
	public boolean login(String user_id,String user_pw) {
		UserDAO udao = new UserDAO();
		UserDTO user = udao.getUserByUserid(user_id);
		if(user != null) {
			if(user.getUser_pw().equals(user_pw)) {
				Session.setData("loginUser", user.getUser_id());
				return true;
			}
		}
		return false;
	}

	public long getUserMoney(String user_id) {
		UserDAO udao = new UserDAO();
		return udao.getUserMoney(user_id);
	}
	
	public int getUserMilage(String user_id) {
		UserDAO udao = new UserDAO();
		return udao.getUserMilage(user_id);
	}

	public boolean setUserMilage(String user_id,int user_milage) {
		UserDAO udao = new UserDAO();
		return udao.setUserMilage(user_id,user_milage);
	}

	public boolean setUserMoney(String user_id,long user_money) {
		UserDAO udao = new UserDAO();
		return udao.setUserMoney(user_id,user_money);
	}

	public HashMap<String, Object> getDetail(String loginUser) {
		UserDAO udao = new UserDAO();
		UserDTO user = udao.getUserByUserid(loginUser);
		HashMap<String, Object> datas = new HashMap<>();
		datas.put("user", user);
		return datas;
	}

	public boolean change_pw(String user_id,String newpw) {
		UserDAO udao = new UserDAO();
		return udao.change_pw(user_id,newpw);
		
	}

	public boolean change_addr(String user_id, String newaddr) {
		UserDAO udao = new UserDAO();
		return udao.chage_addr(user_id,newaddr);
		
	}

	public boolean leaveId(String user_id) {
		UserDAO udao = new UserDAO();
		return udao.leaveID(user_id);
	}
	public boolean plusMilage(String user_id) {
		UserDAO udao = new UserDAO();
		return udao.plusMilage(user_id);
	}
}
