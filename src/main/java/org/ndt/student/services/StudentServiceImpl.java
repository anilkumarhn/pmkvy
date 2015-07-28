package org.ndt.student.services;

import java.util.List;

import org.ndt.student.db.StudentDao;
import org.ndt.student.entity.AssessmentResult;
import org.ndt.student.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StudentServiceImpl  implements StudentService
{
	
	@Autowired
	private StudentDao studentDao;
	
	public StudentDao getStudentDao() 
	{
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao)
	{
		this.studentDao = studentDao;
	}


	
	@Transactional
	public void createStudent(MultipartFile file) 
	{
		 studentDao.createStudent(file);
	}
	@Transactional
	public List<Student> getAllStudentList()
	{
		// TODO Auto-generated method stub
		return studentDao.getAllStudentList();
	}

	@Override
	@Transactional
	public void uploadStudentDetails(MultipartFile file) 
	{
		 studentDao.uploadStudentDetails(file);
	}

	@Override
	public void editStudent(Student student)
	{
		studentDao.editStudent(student);
	}

	@Override
	public List<AssessmentResult> getAllAssessmentResult() {
		return studentDao.getAllAssessmentResult();
	}
}
