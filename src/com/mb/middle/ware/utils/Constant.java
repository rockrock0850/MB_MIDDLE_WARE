package com.mb.middle.ware.utils;

public class Constant {
	
	/*
	 *  
	 */
	
	public final static String IV = ShareTool.getProperty("aes.iv");
	public final static String KEY = ShareTool.getProperty("aes.key");
	
	/*
	 * Api URI
	 */

	public final static String MAIN_LIST_EMPLOYEE_API = ShareTool.getProperty("domain") + "/MB_MAIN_SYSTEM/MainSystemApi/employee";
	public final static String MAIN_NEW_EMPLOYEE_API = ShareTool.getProperty("domain") + "/MB_MAIN_SYSTEM/MainSystemApi/newEmployee";
	public final static String MAIN_DETAIL_EMPLOYEE_API = ShareTool.getProperty("domain") + "/MB_MAIN_SYSTEM/MainSystemApi/editEmployeeDetail";
	public final static String MAIN_UPDATE_EMPLOYEE_API = ShareTool.getProperty("domain") + "/MB_MAIN_SYSTEM/MainSystemApi/updateEmployee";
	public final static String MAIN_DELETE_EMPLOYEE_API = ShareTool.getProperty("domain") + "/MB_MAIN_SYSTEM/MainSystemApi/deleteEmployee";
	public final static String MAIN_LOGIN_API = ShareTool.getProperty("domain") + "/MB_MAIN_SYSTEM/MainSystemApi/login";
	public final static String MAIN_GET_ENTERPRISE_SERVICES_API = ShareTool.getProperty("domain") + "/MB_MAIN_SYSTEM/MainSystemApi/getEnterpriseServices";
	
	/*
	 * Jsp path
	 */

	public final static String SYSTEM_INDEX = "employee/index";
	public final static String SYSTEM_INVALID = "employee/invalid";
	
	/*
	 * 系統狀態
	 */
	
	public enum Status { 
		SELECT_USER_MSG001("無此使用者"),
		
		CREATE_USER_MSG001("帳號已存在"),
		CREATE_USER_MSG002("請確認密碼是否一致"),
		CREATE_USER_MSG003("註冊失敗"),
		
		DELETE_USER_MSG001("刪除失敗"),

		UPDATE_USER_MSG001("更新失敗"),
		UPDATE_USER_MSG002("密碼錯誤"),
		
		LOGIN_MSG001("錯誤的帳號或密碼"),
		
		FIELD_MSG001("必要欄位不足"), 
		
		EXCEPTION_RECORD_MSG001("無此錯誤紀錄"),
		EXCEPTION_RECORD_MSG002("新增失敗"),
		
		SUCCESS("200", "執行成功"),
		UNKNOWN_ERROR("999", "未知的錯誤");
		
		private String code;
		private String message;
		
		private Status(String message) {
			this.message = message;
		}
		
		private Status(String code, String message) {
			this.code = code;
			this.message = message;
		}
		
		/*
		 * setter getter
		 */
		
		public String getMessage() {
			return message;
		}

		public String getCode() {
			return code;
		}
	}
}
