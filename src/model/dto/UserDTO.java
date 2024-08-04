package model.dto;

public class UserDTO {
	private String user_id;
	private String user_name;
	private String user_pw;
	private String user_phone;
	private String user_address;
	private long user_money;
	private int user_milage;

	public UserDTO() {
	}
	public UserDTO(String user_id, String user_name, String user_pw, String user_phone, String user_addresss) {
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_pw = user_pw;
		this.user_phone = user_phone;
		this.user_address = user_addresss;
	}

	public UserDTO(String user_id, String user_name, String user_pw, String user_phone, String user_addresss,
			long user_money, int user_milage) {
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_pw = user_pw;
		this.user_phone = user_phone;
		this.user_address = user_addresss;
		this.user_money = user_money;
		this.user_milage = user_milage;
	}
	
	public UserDTO(long user_money) {
		this.user_money = user_money;
	}
	
	public UserDTO(int user_milage) {
		this.user_milage = user_milage;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public long getUser_money() {
		return user_money;
	}
	public void setUser_money(int user_money) {
		this.user_money = user_money;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public void setUser_milage(int user_milage) {
		this.user_milage = user_milage;
	}
	public int getUser_milage() {
		return user_milage;
	}
}
