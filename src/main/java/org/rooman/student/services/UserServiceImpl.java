package org.rooman.student.services;

import java.util.List;

import org.rooman.student.db.UserDao;
import org.rooman.student.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService 
{
	@Autowired
	private UserDao userDao;

	@Override
	public void createUser(User user) 
	{
		userDao.createUser(user);
	}

	@Override
	public List<User> getAllUsers() 
	{
		return userDao.getAllUsers();
	}

	@Override
	public void updateUser(User user) 
	{
		userDao.updateUser(user);
	}

	@Override
	public User authenticateUser(User user) 
	{
		return userDao.authenticateUser(user);
	}

	@Override
	public User getMyProfile(String userName) 
	{
		return userDao.getMyProfile(userName);
	}
}
