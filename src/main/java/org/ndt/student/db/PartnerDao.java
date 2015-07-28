package org.ndt.student.db;

import org.springframework.web.multipart.MultipartFile;

public interface PartnerDao 
{
	public void uploadPartnerDatails(MultipartFile file);
}
