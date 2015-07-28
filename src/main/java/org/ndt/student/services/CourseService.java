package org.ndt.student.services;

import org.springframework.web.multipart.MultipartFile;

public interface CourseService 
{
	public void uploadCourseDetails(MultipartFile file);
}
