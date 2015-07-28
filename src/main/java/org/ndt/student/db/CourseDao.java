package org.ndt.student.db;

import org.springframework.web.multipart.MultipartFile;

public interface CourseDao 
{
	public void uploadCourseDetails(MultipartFile file);
}
