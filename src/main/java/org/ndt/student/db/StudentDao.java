package org.ndt.student.db;

import java.util.List;

import org.ndt.student.entity.AssessmentResult;
import org.ndt.student.entity.Student;
import org.springframework.web.multipart.MultipartFile;

public interface StudentDao 
{
	public void createStudent(MultipartFile file);

	public List<Student> getAllStudentList();

	public void uploadStudentDetails(MultipartFile file);

	public void editStudent(Student student);

	public List<AssessmentResult> getAllAssessmentResult();
}
