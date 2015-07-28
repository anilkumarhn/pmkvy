package org.ndt.student.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "USER")
public class User implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Long userID;
	private String userName;
	private String password;
	private String userRole;
	private String accountActive;
	
	public User()
	{
		super();
	}
	
	public User(String userName, String password, String userRole,String accountActive)
	{
		super();
		this.userName = userName;
		this.password = password;
		this.userRole = userRole;
		this.accountActive = accountActive;
	}
	
	@Id
	@GeneratedValue
	@Column( name = "USER_ID")
	public Long getUserID()
	{
		return userID;
	}
	
	@Column( name = "USER_NAME")
	public String getUserName()
	{
		return userName;
	}
	
	@Column( name = "PASSWORD")
	public String getPassword() 
	{
		return password;
	}
	
	@Column( name = "USER_ROLE")
	public String getUserRole() 
	{
		return userRole;
	}
	
	@Column( name = "ACCOUNT_ACTIVE")
	public String getAccountActive() 
	{
		return accountActive;
	}
	
	
	public void setUserID(Long userID) 
	{
		this.userID = userID;
	}
		
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public void setUserRole(String userRole) 
	{
		this.userRole = userRole;
	}
	
	public void setAccountActive(String accountActive) 
	{
		this.accountActive = accountActive;
	}
	
	@Override
	public String toString() 
	{
		return "User [userID=" + userID + ", userName=" + userName + ", password=" + password + ", userRole=" + userRole
				+ ", accountActive=" + accountActive + "]";
	}
}
