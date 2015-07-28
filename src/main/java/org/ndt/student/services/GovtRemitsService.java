package org.ndt.student.services;

import java.util.List;

import org.ndt.student.entity.GovtRemits;
import org.ndt.student.entity.Student;

public interface GovtRemitsService 
{
	public void uploadGovtRemitsDetails(GovtRemits govtRemits);

	public List<GovtRemits> getAllStudentList(String batchID);

	public void editGovtRemits(Student student, GovtRemits govtRemits);
}
