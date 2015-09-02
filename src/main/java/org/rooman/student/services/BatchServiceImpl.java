package org.rooman.student.services;

import java.util.List;

import org.rooman.student.db.BatchDao;
import org.rooman.student.entity.Batch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BatchServiceImpl  implements BatchService
{
	@Autowired
	private BatchDao batchDao;
	
	@Override
	public List<Batch> getBatchList() 
	{
		return batchDao.getBatchList();
	}

	@Override
	public void updateBatchInfo(Batch batch) 
	{
		 batchDao.updateBatchInfo(batch);
	}

	@Override
	public Batch getBatchById(String batchID)
	{
		return batchDao.getBatchById(batchID);
	}

	@Override
	public List<Batch> getBatchByTestStatus(String testStatus) {
		// TODO Auto-generated method stub
		return batchDao.getBatchByTestStatus(testStatus);
	}
}
