package org.ndt.student.services;

import org.ndt.student.db.PartnerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
@Service
@Transactional
public class PartnerServiceImpl implements PartnerService
{
	
	@Autowired
	private PartnerDao partnerDao;
	
	public PartnerDao getPartnerDao() 
	{
		return partnerDao;
	}

	public void setPartnerDao(PartnerDao partnerDao)
	{
		this.partnerDao = partnerDao;
	}

	@Override
	public void uploadPartnerDatails(MultipartFile file) 
	{
		partnerDao.uploadPartnerDatails(file);
	}
	
}
