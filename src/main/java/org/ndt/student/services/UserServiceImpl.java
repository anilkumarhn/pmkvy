package org.ndt.student.services;

import org.ndt.student.db.UserDao;
import org.ndt.student.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService 
{
	@Autowired
	private UserDao userDao;

	public User getUser(String login) 
	{
		return userDao.getUser(login);
	}
}
