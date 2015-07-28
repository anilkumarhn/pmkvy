package org.ndt.student.db;

import org.springframework.web.multipart.MultipartFile;

public interface AccountDao 
{
	public void uploadAccountInfo(MultipartFile file);
}
