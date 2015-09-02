package org.rooman.student.services;

import org.rooman.student.db.AssessmentFeeDao;
import org.rooman.student.entity.AssessmentFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AssessmentFeeServiceImpl implements AssessmentFeeService
{
	@Autowired
	private AssessmentFeeDao assessmentFeeDao;
	
	@Override
	public boolean updateAssmtFeeInfo(AssessmentFee assessmentFee) 
	{
		return assessmentFeeDao.updateAssmtFeeInfo(assessmentFee);
	}
}
