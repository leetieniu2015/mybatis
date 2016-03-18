package org.lee.model.pojo;

public class User {
	
	public Long memberId;
	public String mobile;
	public String userName;
	
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public String toString() {
		return "User : { memberId : " + memberId + ", mobile : " + mobile + ", userName : " + userName + " }";
	}
}
