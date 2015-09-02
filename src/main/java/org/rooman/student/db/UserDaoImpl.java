package org.rooman.student.db;



import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.rooman.student.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao
{
	private static final Logger logger = Logger.getLogger(UserDaoImpl.class);
	
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

	@Override
	public void createUser(User user) 
	{
		if(user != null)
		{
			Session session = sessionFactory.openSession();
			Transaction txn = session.beginTransaction();
			try
			{
				session.save(user);
				txn.commit();
			}
			catch(HibernateException hbe)
			{
				hbe.printStackTrace();
				logger.debug("Error in user creation.....");
				txn.rollback();
			}
			finally
			{
				session.close();
			}
		}
		else
		{
			logger.debug("Empty object passes.....");
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() 
	{
		Session session = sessionFactory.openSession();
		List<User> userList = null;
		try
		{
			userList = session.createCriteria(User.class).list();
		}
		catch( HibernateException hbe)
		{
			logger.debug(hbe.getCause().getMessage());
		}
		finally
		{
			session.close();
		}
		return userList;
	}

	@Override
	public void updateUser(User user) 
	{
		if(user != null)
		{
			Session session = sessionFactory.openSession();
			Transaction txn = session.beginTransaction();
			try
			{
				session.update(user);
				session.flush();
				txn.commit();
			}
			catch(HibernateException hbe)
			{
				hbe.printStackTrace();
				txn.rollback();
				logger.debug("error in user updation.....");
			}
			finally
			{
				session.close();
			}
		}
		else
		{
			logger.debug("null object passes......");
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public User authenticateUser(User user) 
	{
		User authenticatedUser = null;
		if(user != null)
		{
			Session session = sessionFactory.openSession();
			String hql = "from User as u where u.userName=:username and u.password=:password";
			Query query = session.createQuery(hql);
			query.setParameter("username", user.getUserName());
			query.setParameter("password", user.getPassword());
			List<User> userData = null;
			try
			{
				userData = query.list();
				if(userData.size() > 0)
				{
					authenticatedUser = userData.get(0);
					authenticatedUser.setId(null);
					authenticatedUser.setFirstName(null);
					authenticatedUser.setLastName(null);
					authenticatedUser.setPassword(null);
					logger.debug("user found....."+authenticatedUser);
				}
				else
				{
					logger.debug("user not found.....");
				}
			}
			catch(HibernateException hbe)
			{
				hbe.printStackTrace();
			}
			finally
			{
				session.close();
			}
		}
		else
		{
			logger.debug("user object is empty.....");
		}
		return authenticatedUser;
	}

	@Override
	@SuppressWarnings("unchecked")
	public User getMyProfile(String userName) 
	{
		User user = null;
		if(!userName.isEmpty())
		{
			Session session = sessionFactory.openSession();
			String hql = "from User as u where u.userName=:username";
			Query query = session.createQuery(hql);
			query.setParameter("username", userName);
			List<User> userData = null;
			try
			{
				userData = query.list();
				if(userData.size() > 0)
				{
					user = userData.get(0);
					logger.debug("user found....."+user);
				}
				else
				{
					logger.debug("user not found.....");
				}
			}
			catch(HibernateException hbe)
			{
				hbe.printStackTrace();
			}
			finally
			{
				session.close();
			}
		}
		else
		{
			logger.debug("user name is empty.....");
		}
		return user;
	}
}
