package org.ndt.student.services;

import java.util.List;

import org.ndt.student.entity.AssessmentResult;
import org.ndt.student.entity.Student;
import org.springframework.web.multipart.MultipartFile;

public interface StudentService 
{
	public void createStudent(MultipartFile file);

	public List<Student> getAllStudentList();
	//public List getAllStudentList();
	public void uploadStudentDetails(MultipartFile file);

	public void editStudent(Student student);

	public List<AssessmentResult> getAllAssessmentResult();
}
