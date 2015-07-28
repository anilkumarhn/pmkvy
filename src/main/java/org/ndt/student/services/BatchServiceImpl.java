package org.ndt.student.services;

import java.util.List;

import org.ndt.student.db.BatchDao;
import org.ndt.student.entity.Batch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BatchServiceImpl  implements BatchService
{
	@Autowired
	private BatchDao batchDao;
	
	public BatchDao getBatchDao() 
	{
		return batchDao;
	}

	public void setBatchDao(BatchDao batchDao) 
	{
		this.batchDao = batchDao;
	}

	
	@Transactional
	public void createBatch(MultipartFile file) 
	{
		batchDao.createBatch(file);
	}

	@Transactional
	public List<Batch> getBatchList() 
	{
		
		return batchDao.getBatchList();
	}
	@Transactional
	public void editBatch(Batch batch) {
		// TODO Auto-generated method stub
		 batchDao.editBatch(batch);
	}

	
}
