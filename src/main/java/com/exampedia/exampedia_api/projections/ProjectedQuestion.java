package com.exampedia.exampedia_api.projections;

public interface ProjectedQuestion {

	int getQuestionId();
	  int getExamId();
	  String getStatement();
	  String getOptionA();
	  String getOptionB();
	  String getOptionC();
	  String getOptionD();
	  String getMarks();
	  String getType();
}
