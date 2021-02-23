package com.xiudoua.micro.study.model;

/**
 * @desc
 * @author JustFresh
 * @time 2021年2月19日 下午12:41:40
 */
public class AddressVO extends AbsVO{

	private static final long serialVersionUID = 4668564877332828839L;
	private String address;
	private String phone;
	private UserinfoVO userinfo;
	
	public AddressVO() {}
	
	/**
	 * @param address
	 * @param phone
	 * @param userinfo
	 */
	public AddressVO(String address, String phone) {
		super();
		this.address = address;
		this.phone = phone;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the userinfo
	 */
	public UserinfoVO getUserinfo() {
		return userinfo;
	}
	/**
	 * @param userinfo the userinfo to set
	 */
	public void setUserinfo(UserinfoVO userinfo) {
		this.userinfo = userinfo;
	}
}