package br.com.rafael.ubs.vo;

import br.com.rafael.ubs.model.User;

public class UserVO {

	private String name;
	private String email;
	
	public UserVO(User user) {
		this.name = user.getName();
		this.email = user.getEmail();
	}
	
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	
}
