package org.ndt.student.services;

import java.io.Serializable;
import java.util.List;

import org.ndt.student.entity.Centre;
import org.ndt.student.entity.Sector;

public interface CentreService extends Serializable
{
	public void uploadCentreDetails(Centre centreDetails);
	public List<Centre> getAllCentres();
	public List<Sector> getAllSectors();
}
