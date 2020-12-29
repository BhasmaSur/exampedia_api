package com.exampedia.exampedia_api.projections;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public interface ProjectedExam {

	int getExamId();

	String getExamName();

	String getExamDescription();

	String getExamSubjects();

	String getExamFees();

	boolean getExamFree();

	boolean getExamSoldSeparately();
}
