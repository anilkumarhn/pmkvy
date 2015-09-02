package org.rooman.student.db;

import java.util.List;

import org.rooman.student.entity.Student;

public interface StudentDao 
{
	public List<Student> getAllStudentList();
	public boolean updateStudent(Student student);
	public Student getStudentById(String candidateID);
	public List<Student> getStudentByAadharVal(String aadharVal);
}
