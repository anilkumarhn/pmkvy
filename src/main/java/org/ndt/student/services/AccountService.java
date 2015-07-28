package org.ndt.student.services;

import org.springframework.web.multipart.MultipartFile;

public interface AccountService 
{
	public void uploadAccountInfo(MultipartFile file);
}
