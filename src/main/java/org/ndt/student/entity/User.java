package org.ndt.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class User 
{
	@Id
	@GeneratedValue
	@Column( name = "ID" )
	private Integer id;
	
	@Column( name ="USER_NAME")
	private String userName;
	
	@Column( name ="PASSWORD")
	private String password;
	
	/*@OneToOne(cascade=CascadeType.ALL)
	@JoinTable(name="USER_ROLES",joinColumns = {@JoinColumn(name="USER_ID", referencedColumnName="ID")},inverseJoinColumns = {@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
	private Role role;

*/	public Integer getId() 
	{
		return id;
	}

	public User() 
	{
		super();
	}
	
	public User(Integer id, String userName, String password) 
	{
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
	}

	public void setId(Integer id) 
	{
		this.id = id;
	}
	
	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName) 
	{
		this.userName = userName;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}
}
