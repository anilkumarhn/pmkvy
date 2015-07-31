package org.ndt.student.services;

import org.ndt.student.db.SectorDao;
import org.ndt.student.entity.Sector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SectorServiceImpl implements SectorService
{
	
	@Autowired
	private SectorDao sectorDao;
	
	public SectorDao getSectorDao() 
	{
		return sectorDao;
	}

	public void setSectorDao(SectorDao sectorDao)
	{
		this.sectorDao = sectorDao;
	}

	@Override
	public void uploadSectorDetails(Sector sectorDetails) 
	{
		sectorDao.uploadSectorDetails(sectorDetails);
	}
}
