package org.ndt.student.services;

import javax.annotation.Resource;

import org.ndt.student.db.AssessmentResultDao;
import org.ndt.student.entity.AssessmentResult;
import org.ndt.student.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssessmentResultServiceImpl implements AssessmentResultService
{
	@Autowired
	@Resource
	private AssessmentResultDao assessmentResultDao;

	public AssessmentResultDao getAssessmentResultDao() 
	{
		return assessmentResultDao;
	}

	public void setAssessmentResultDao(AssessmentResultDao assessmentResultDao) 
	{
		this.assessmentResultDao = assessmentResultDao;
	}
	
	@Override
	public void editAssessmentResult(Student student,AssessmentResult assessmentResult)
	{
		assessmentResultDao.editAssessmentResult(student,assessmentResult);
	}

		
}
