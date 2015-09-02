package org.rooman.student.services;

import java.util.List;

import org.rooman.student.entity.Course;

public interface CourseService 
{
	public Course findCourseByIdForUpload(String courseId);
	public List<Course> getSetctors();
	public Course getCourseById(String courseId); 
	public void updateCourseInfo(Course course);
}
