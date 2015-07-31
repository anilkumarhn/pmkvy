package org.ndt.student.db;

import org.ndt.student.entity.User;

public interface UserDao
{
	public User getUser(String login);
}
