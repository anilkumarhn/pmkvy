package org.rooman.student.db;

import org.rooman.student.entity.GovtRemits;

public interface GovtRemitsDao 
{
	public boolean updateGovtRemits(GovtRemits govtRemits);

	public GovtRemits getGovtRemit(String transactionID);
}
