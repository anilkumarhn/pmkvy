package org.ndt.student.db;

import org.ndt.student.entity.AssessmentResult;
import org.ndt.student.entity.Student;

public interface AssessmentResultDao 
{
		public void editAssessmentResult(Student student,AssessmentResult assessmentResult);
}
