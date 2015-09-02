package org.rooman.student.services;

import java.util.Collection;
import java.util.List;

import org.rooman.student.db.PartnerDao;
import org.rooman.student.entity.Partner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PartnerServiceImpl implements PartnerService
{

	@Autowired
	private PartnerDao partnerDao;

	@Override
	public List<Partner> getPartnerList() 
	{
		return partnerDao.getPartnerList();
	}
	
	@Override
	public Partner getPartnerById(String partnerId) 
	{
		return partnerDao.getPartnerById(partnerId);
	}

	@Override
	public void bulkUploadPartnerDeatils(Collection<Partner> partnerList) 
	{
		partnerDao.bulkUploadPartnerDeatils(partnerList);
	}

	@Override
	public boolean updatePartnerInfo(Partner partner) 
	{
		 return partnerDao.updatePartnerInfo(partner);
	}

	@Override
	public Partner getPartnerByMail(String userName) {
		// TODO Auto-generated method stub
		return partnerDao.getPartnerByMail(userName);
	}
}
