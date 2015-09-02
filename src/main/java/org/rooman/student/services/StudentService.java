package org.rooman.student.services;

import java.util.List;

import org.rooman.student.entity.Student;

public interface StudentService 
{
	public List<Student> getAllStudentList();
	public boolean updateStudent(Student student);
	public Student getStudentById(String candidateID);
	public List<Student> getStudentByAadharVal(String aadharVal);
}
