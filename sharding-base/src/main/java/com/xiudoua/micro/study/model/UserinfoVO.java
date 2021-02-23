package com.xiudoua.micro.study.model;

/**
 * @desc
 * @author JustFresh
 * @time 2021年2月19日 下午12:42:08
 */
public class UserinfoVO extends AbsVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8996973375206226650L;
	private String username;
	private String password;
	private String email;
	
	public UserinfoVO() {}
	
	/**
	 * @param username
	 * @param password
	 * @param email
	 */
	public UserinfoVO(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
}