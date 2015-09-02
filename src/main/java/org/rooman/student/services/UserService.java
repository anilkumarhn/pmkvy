package org.rooman.student.services;

import java.util.List;

import org.rooman.student.entity.User;

public interface UserService 
{
	public void createUser(User user); 
	public List<User> getAllUsers();
	public void updateUser(User user);
	public User authenticateUser(User user);
	public User getMyProfile(String userName);
}
