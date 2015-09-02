package org.rooman.student.db;

import java.util.List;

import org.rooman.student.entity.Course;


public interface CourseDao 
{
	public Course findCourseByIdForUpload(String courseId); 
	public List<Course> getSetctors();
	public Course getCourseById(String courseId);
	public void updateCourseInfo(Course course);
}
