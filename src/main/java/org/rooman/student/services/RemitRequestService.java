package org.rooman.student.services;

import org.rooman.student.entity.RemitRequest;

public interface RemitRequestService 
{
	public boolean getRemitById(String studentId);
	public boolean postRemitRequest(RemitRequest remitRequest);
}
