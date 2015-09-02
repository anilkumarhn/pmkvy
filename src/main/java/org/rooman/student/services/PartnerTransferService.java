package org.rooman.student.services;

import org.rooman.student.entity.PartnerTransfer;

public interface PartnerTransferService 
{
	public void uploadPartnerTransfer(PartnerTransfer transfer);
	public boolean getTransactionByIdForUpload(String transactionId);
}
