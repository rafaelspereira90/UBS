package br.com.rafael.ubs.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class UserForm {

	@NotNull @NotEmpty @Length(min = 4, max = 20)
	private String name;
	@NotNull @NotEmpty @Length(min = 8, max = 40)
	private String email;
	@NotNull @NotEmpty @Length(min = 6, max = 15)
	private String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
