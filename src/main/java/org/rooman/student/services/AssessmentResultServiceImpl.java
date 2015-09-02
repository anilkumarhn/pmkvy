package org.rooman.student.services;

import org.rooman.student.db.AssessmentResultDao;
import org.rooman.student.entity.AssessmentResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AssessmentResultServiceImpl implements AssessmentResultService
{
	@Autowired
	private AssessmentResultDao assessmentResultDao;

	@Override
	public boolean updateAssmtResultInfo(AssessmentResult assessmentResult)
	{
		return assessmentResultDao.updateAssmtResultInfo(assessmentResult);
	}
}
