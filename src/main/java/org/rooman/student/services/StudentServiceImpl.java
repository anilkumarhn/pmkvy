package org.rooman.student.services;

import java.util.List;

import org.rooman.student.db.StudentDao;
import org.rooman.student.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentServiceImpl  implements StudentService
{
	
	@Autowired
	private StudentDao studentDao;
	
	@Override
	public List<Student> getAllStudentList()
	{
		return studentDao.getAllStudentList();
	}
	
	@Override
	public boolean updateStudent(Student student) 
	{
		return studentDao.updateStudent(student);
	}

	@Override
	public Student getStudentById(String candidateID) 
	{
		return studentDao.getStudentById(candidateID);
	}

	@Override
	public List<Student> getStudentByAadharVal(String aadharVal) {
		// TODO Auto-generated method stub
		return studentDao.getStudentByAadharVal(aadharVal);
	}

}
