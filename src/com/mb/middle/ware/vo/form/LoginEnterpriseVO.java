package com.mb.middle.ware.vo.form;

import org.hibernate.validator.constraints.NotBlank;

public class LoginEnterpriseVO {
	@NotBlank(message = "請輸入特店代號")
	private String storeNo;

	@NotBlank(message = "請輸入帳號")
	private String account;

	@NotBlank(message = "請輸入密碼")
	private String password;

	/*
	 * 
	 */

	public String getStoreNo() {
		return storeNo;
	}

	public void setStoreNo(String storeNo) {
		this.storeNo = storeNo;
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
}
