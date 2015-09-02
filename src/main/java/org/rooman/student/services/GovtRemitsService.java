package org.rooman.student.services;

import org.rooman.student.entity.GovtRemits;

public interface GovtRemitsService 
{
	public boolean updateGovtRemits(GovtRemits govtRemits);
	public GovtRemits getGovtRemit(String transactionID);
}
