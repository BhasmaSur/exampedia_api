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
		
		Exam exam1=new Exam(1,"NDA","Army","MATHS,APTITUDE","20","30","40",true);
		Exam exam2=new Exam(2,"BE","ENGINEERING","BCS,BBA","20","40","60",true);
		examSet1.add(exam1);
		examSet1.add(exam2);
		return examSet1;
	}
	public List<Exam> getDummyExamsSet2(){
		List<Exam> examSet2=new ArrayList<>();
		
		Exam exam3=new Exam(3,"TCS","Army","MATHS,APTITUDE","20","100","3600",true);
		Exam exam4=new Exam(4,"RJ","ENGINEERING","BCS,BBA","20","200","120",true);
		examSet2.add(exam3);
		examSet2.add(exam4);
		return examSet2;
	}

	
}
