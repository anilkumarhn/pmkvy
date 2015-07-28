package org.ndt.student.services;

import org.ndt.student.db.CourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CourseServiceImpl implements CourseService 
{
	@Autowired
	private CourseDao courseDao;

	public CourseDao getCourseDao() 
	{
		return courseDao;
	}

	public void setCourseDao(CourseDao courseDao) 
	{
		this.courseDao = courseDao;
	}

	
	@Transactional
	public void uploadCourseDetails(MultipartFile file)
	{
		courseDao.uploadCourseDetails(file);
	}
}
