package org.ndt.student.services;

import org.ndt.student.db.RoomanRemitsDao;
import org.ndt.student.entity.RoomanRemits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoomanRemitsServiceImpl implements RoomanRemitsService
{
	@Autowired
	private RoomanRemitsDao roomanRemitsDao;

	public RoomanRemitsDao getRoomanRemitsDao() 
	{
		return roomanRemitsDao;
	}

	public void setRoomanRemitsDao(RoomanRemitsDao roomanRemitsDao) 
	{
		this.roomanRemitsDao = roomanRemitsDao;
	}

	@Override
	public void uploadRoomanRemitsDetails(RoomanRemits roomanRemits) 
	{
		roomanRemitsDao.uploadRoomanRemitsDetails(roomanRemits);
	}
}
