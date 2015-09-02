package org.rooman.student.services;

import org.rooman.student.db.PartnerTransferDao;
import org.rooman.student.entity.PartnerTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PartnerTransferServiceImpl implements PartnerTransferService
{
	@Autowired
	private PartnerTransferDao partnerTransferDao;

	@Override
	public void uploadPartnerTransfer(PartnerTransfer transfer) 
	{
		partnerTransferDao.uploadPartnerTransfer(transfer);
	}

	@Override
	public boolean getTransactionByIdForUpload(String transactionId)
	{
		return partnerTransferDao.getTransactionByIdForUpload(transactionId);
	}
}
