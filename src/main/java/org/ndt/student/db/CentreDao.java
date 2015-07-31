package org.ndt.student.db;

import java.util.List;

import org.ndt.student.entity.Centre;
import org.ndt.student.entity.Sector;

public interface CentreDao
{
	public void uploadCentreDetails(Centre centreDetails);
	public List<Centre> getAllCentres();
	public List<Sector> getAllSectors();
}
