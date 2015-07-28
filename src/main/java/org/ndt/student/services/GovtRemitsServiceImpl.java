package org.ndt.student.services;

import java.util.List;

import org.ndt.student.db.GovtRemitsDao;
import org.ndt.student.entity.GovtRemits;
import org.ndt.student.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GovtRemitsServiceImpl implements GovtRemitsService
{
	
	@Autowired
	private GovtRemitsDao govtRemitsDao;
	
	public GovtRemitsDao getGovtRemitsDao()
	{
		return govtRemitsDao;
	}

	public void setGovtRemitsDao(GovtRemitsDao govtRemitsDao)
	{
		this.govtRemitsDao = govtRemitsDao;
	}

	@Override
	@Transactional
	public void uploadGovtRemitsDetails(GovtRemits govtRemits) 
	{
		govtRemitsDao.uploadGovtRemitsDetails(govtRemits);
	}

	@Override
	public List<GovtRemits> getAllStudentList(String batchID) 
	{
		return govtRemitsDao.getAllStudentList(batchID);
	}

	@Override
	public void editGovtRemits(Student student, GovtRemits govtRemits)
	{
		govtRemitsDao.editGovtRemits(student,govtRemits);
	}

}
