package org.rooman.student.db;

import org.rooman.student.entity.PartnerTransfer;

public interface PartnerTransferDao 
{
	public void uploadPartnerTransfer(PartnerTransfer transfer);
	public boolean getTransactionByIdForUpload(String transactionId);
}
