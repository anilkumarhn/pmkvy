package org.ndt.student.services;

import java.util.List;

import org.ndt.student.db.CentreDao;
import org.ndt.student.entity.Centre;
import org.ndt.student.entity.Sector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class CentreServiceImp implements CentreService
{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CentreDao centreDao;
	
	@Override
	public void uploadCentreDetails(Centre centreDetails) 
	{
		centreDao.uploadCentreDetails(centreDetails);
	}
	
	public List<Centre> getAllCentres()
	{
		return centreDao.getAllCentres();
		
	}
	
	@Override
	public List<Sector> getAllSectors() 
	{
		return centreDao.getAllSectors();
	}
}
