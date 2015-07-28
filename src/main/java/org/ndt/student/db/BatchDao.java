package org.ndt.student.db;

import java.util.List;

import org.ndt.student.entity.Batch;
import org.springframework.web.multipart.MultipartFile;

public interface BatchDao 
{
	public void createBatch( MultipartFile file);

	public List<Batch> getBatchList();

	public void editBatch(Batch batch);


}
