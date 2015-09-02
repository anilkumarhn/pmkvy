package org.rooman.student.db;

import java.util.List;

import org.rooman.student.entity.Batch;

public interface BatchDao 
{
	public List<Batch> getBatchList();
	public void updateBatchInfo(Batch batch);
	public Batch getBatchById(String batchID);
	public List<Batch> getBatchByTestStatus(String testStatus);
}
