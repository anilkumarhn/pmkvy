package org.rooman.student.services;

import org.rooman.student.db.RemitRequestDao;
import org.rooman.student.entity.RemitRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemitRequestServiceImpl implements RemitRequestService 
{
	@Autowired
	private RemitRequestDao remitRequestDao;

	@Override
	public boolean getRemitById(String studentId)
	{
		return remitRequestDao.getRemitById(studentId);
	}

	@Override
	public boolean postRemitRequest(RemitRequest remitRequest) 
	{
		return remitRequestDao.postRemitRequest(remitRequest);
	}
}
