package org.ndt.student.db;

import java.util.List;

import org.ndt.student.entity.GovtRemits;
import org.ndt.student.entity.Student;

public interface GovtRemitsDao
{
	public void uploadGovtRemitsDetails(GovtRemits govtRemits);

	public List<GovtRemits> getAllStudentList(String batchID);

	public void editGovtRemits(Student student, GovtRemits govtRemits);
}
