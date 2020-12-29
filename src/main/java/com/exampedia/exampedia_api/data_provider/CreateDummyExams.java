package com.exampedia.exampedia_api.data_provider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.exampedia.exampedia_api.model.Exam;

@Component
public class CreateDummyExams {

	public CreateDummyExams() {
		
	}
	public List<Exam> getDummyExamsSet1(){
		List<Exam> examSet1=new ArrayList<>();
		
		Exam exam1=new Exam(1,"NDA","Army","MATHS,APTITUDE","20",false,"NDA.xlsx",true);
		Exam exam2=new Exam(1,"BE","ENGINEERING","BCS,BBA","20",false,"be.xlsx",true);
		examSet1.add(exam1);
		examSet1.add(exam2);
		return examSet1;
	}
	public List<Exam> getDummyExamsSet2(){
		List<Exam> examSet2=new ArrayList<>();
		
		Exam exam3=new Exam(1,"TCS","Army","MATHS,APTITUDE","20",false,"NDA.xlsx",true);
		Exam exam4=new Exam(1,"RJ","ENGINEERING","BCS,BBA","20",false,"be.xlsx",true);
		examSet2.add(exam3);
		examSet2.add(exam4);
		return examSet2;
	}

	
}
