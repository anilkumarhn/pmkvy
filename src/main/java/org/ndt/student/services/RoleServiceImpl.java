package org.ndt.student.services;


import org.ndt.student.db.RoleDao;
import org.ndt.student.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class RoleServiceImpl implements RoleService 
{
	@Autowired
	private RoleDao roleDao; 

	public Role getRole(int id) 
	{
		return roleDao.getRole(id);
	}
}
