package com.mb.middle.ware.vo.form;

import org.hibernate.validator.constraints.NotBlank;

public class UpdateEmployeeVO{
	@NotBlank(message = "請輸入Guid")
	private String guid;
	
	@NotBlank(message = "請輸入帳號")
	private String account;

	@NotBlank(message = "請輸入密碼")
	private String password;

	@NotBlank(message = "請輸入郵件")
	private String email;

	/*
	 * 
	 */
	
	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
