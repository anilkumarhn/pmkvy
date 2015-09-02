package org.rooman.student.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="USERS")
public class User implements Serializable
{

	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column( name = "ID" )
	private Integer id;
	
	@Column( name = "FIRST_NAME")
	private String firstName;
	
	@Column( name = "LAST_NAME")
	private String lastName;
	
	
	@Column( name ="USER_NAME", unique = true)
	private String userName;
	

	@Column( name ="PASSWORD")
	private String password;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinTable(name="USER_ROLES",joinColumns = {@JoinColumn(name="USER_ID", referencedColumnName="ID")},inverseJoinColumns = {@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
	private Role role;

	public User(String firstName, String lastName, String userName,	String password) 
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
	}

	public User(Integer id, String firstName, String lastName, String userName,String password, Role role)
	{
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	public User() 
	{
		super();
	}

	public Integer getId() 
	{
		return id;
	}

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	public String getLastName() 
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
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


	public Role getRole() 
	{
		return role;
	}

	public void setRole(Role role) 
	{
		this.role = role;
	}
	/*
	@Override
	public int hashCode() 
	{
		return (int) this.getId();
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)  return true;
		if ( !(obj instanceof User) ) return false;
		User other = (User) obj;
		return this.id == other.getId();
	}*/
}
