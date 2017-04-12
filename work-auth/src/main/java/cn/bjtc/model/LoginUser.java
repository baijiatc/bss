package cn.bjtc.model;

public class LoginUser {

	private String username;
	private String password;
	private boolean isRemember = false;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isRemember() {
		return isRemember;
	}
	public void setRemember(boolean isRemember) {
		this.isRemember = isRemember;
	}
}
