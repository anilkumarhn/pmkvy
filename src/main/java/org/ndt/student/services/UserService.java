package org.ndt.student.services;

import org.ndt.student.entity.User;

public interface UserService 
{
	public User getUser(String login);
}
