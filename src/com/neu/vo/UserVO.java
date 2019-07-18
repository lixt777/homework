package com.neu.vo;

import java.util.Date;
/**
    * 用户实体类
 * @author Administrator
 *
 */

public class UserVO {
	
	private String userId;
	
	private String userName;
	
	private String password;
	
	private Date lastLogin;
	
	public UserVO()
	{
		
	}
	public UserVO(String userId,String userName,String password)
	{
		this.userId=userId;
		this.password=password;
		this.userName=userName;
	}	
	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	

}
