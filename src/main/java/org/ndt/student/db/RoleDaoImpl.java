package org.ndt.student.db;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.ndt.student.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao
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

	public Role getRole(int id) 
	{
		Session session = sessionFactory.openSession();
		Role role = (Role)session.get(Role.class, id);
		session.close();
		return role;
	}
}
