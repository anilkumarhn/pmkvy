package org.rooman.student.db;

import org.rooman.student.entity.RemitRequest;

public interface RemitRequestDao 
{
	public boolean getRemitById(String studentId);
	public boolean postRemitRequest( RemitRequest remitRequest);
}
