package org.ndt.student.db;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.ndt.student.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() 
	{
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}

	public User getUser(String login) 
	{		
		Session session = sessionFactory.openSession();
		String hql = "from User u where u.login = :login";
		Query query = session.createQuery(hql);
		query.setParameter("login", login);
		List<User> userList = query.list();
		session.close();
		
		if (userList.size() > 0)
		{
			return userList.get(0);
		}
		else
		{
			return null;	
		}
	}
}
