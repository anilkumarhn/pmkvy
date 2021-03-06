package org.rooman.student.db;

import java.util.Collection;
import java.util.List;

import org.rooman.student.entity.Partner;

public interface PartnerDao 
{
	public void bulkUploadPartnerDeatils(Collection<Partner> partnerList);
	public List<Partner> getPartnerList();
	public Partner getPartnerById(String partnerId);
	public boolean updatePartnerInfo(Partner partner);
	public Partner getPartnerByMail(String userName);
}

