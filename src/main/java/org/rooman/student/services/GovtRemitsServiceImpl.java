package org.rooman.student.services;

import org.rooman.student.db.GovtRemitsDao;
import org.rooman.student.entity.GovtRemits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GovtRemitsServiceImpl  implements GovtRemitsService
{
	
	@Autowired
	private GovtRemitsDao govtRemitsDao;
	
	@Override
	public boolean updateGovtRemits(GovtRemits govtRemits) 
	{
		return govtRemitsDao.updateGovtRemits(govtRemits);
	}
	
	@Override
	public GovtRemits getGovtRemit(String transactionID)
	{
		return govtRemitsDao.getGovtRemit(transactionID);
	}

}
