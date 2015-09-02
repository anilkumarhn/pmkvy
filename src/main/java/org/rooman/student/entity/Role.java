package org.rooman.student.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="ROLES")
public class Role implements Serializable 
{
	
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column( name ="ID")
	private Integer id;
	
	@Column( name = "USER_ROLE")
	private String userRole;

	@OneToMany( cascade = CascadeType.ALL)
	@JoinTable(name="USER_ROLES",joinColumns = {@JoinColumn(name="ROLE_ID", referencedColumnName="ID")},inverseJoinColumns = {@JoinColumn(name="USER_ID", referencedColumnName="ID")})
	private Set<User> userRoles;
	
	public Role(String userRole) 
	{
		super();
		this.userRole = userRole;
	}

	public Role()   
	{
		super();
	}

	public String getUserRole() 
	{
		return userRole;
	}

	public void setUserRole(String userRole) 
	{
		this.userRole = userRole;
	}
		
	public Set<User> getUserRoles() 
	{
		return userRoles;
	}

	public void setUserRoles(Set<User> userRoles) 
	{
		this.userRoles = userRoles;
	}
	
	public Integer getId() 
	{
		return id;
	}

	public void setId(Integer id) 
	{
		this.id = id;
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
		if ( !(obj instanceof Role) ) return false;
		Role other = (Role) obj;
		return this.id == other.getId();
	}*/
}
