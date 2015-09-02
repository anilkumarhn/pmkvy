package org.rooman.student.services;

import java.util.List;

import org.rooman.student.db.CourseDao;
import org.rooman.student.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CourseServiceImpl implements CourseService 
{
	@Autowired
	private CourseDao courseDao;

	@Override
	public List<Course> getSetctors() 
	{
		return courseDao.getSetctors();
	}

	@Override
	public Course findCourseByIdForUpload(String courseId) 
	{
		return courseDao.findCourseByIdForUpload(courseId);
	}

	@Override
	public Course getCourseById(String courseId) 
	{
		return courseDao.getCourseById(courseId);
	}

	@Override
	public void updateCourseInfo(Course course) 
	{
	 courseDao.updateCourseInfo(course);	
	}
}
