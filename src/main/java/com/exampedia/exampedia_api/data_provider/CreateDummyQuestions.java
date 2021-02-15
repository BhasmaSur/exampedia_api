package com.exampedia.exampedia_api.data_provider;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.exampedia.exampedia_api.model.Question;

@Component
public class CreateDummyQuestions {

	public CreateDummyQuestions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Question> getListOfDummyQuestions(){
		Question question1=new Question(1,26,"What is the Ph value of human blood?","7.40","7","0","8","A","5","MCQ");
		Question question2=new Question(2,26,"cherry is female dog","True","False","NaN","NaN","A","5","TRUE_FALSE");
		Question question3=new Question(3,26,"Write about HR","NaN","NaN","NaN","NaN","HRs do their job, like we do our job","5","ESSAY");
		Question question4=new Question(4,26,"dog loves","Scratches","boops","food","bath","A,B,C","5","SELECT_ALL");
		Question question5=new Question(5,26,"What is the Ph value of human blood?","7.40","7","0","8","A","5","MCQ");
		Question question6=new Question(6,26,"cherry is female dog","True","False","NaN","NaN","A","5","TRUE_FALSE");
		
		Question question7=new Question(7,27,"What is the Ph value of human blood?","7.40","7","0","8","A","5","MCQ");
		Question question8=new Question(8,27,"cherry is female dog","True","False","NaN","NaN","A","5","TRUE_FALSE");
		Question question9=new Question(9,27,"Write about HR","NaN","NaN","NaN","NaN","HRs do their job, like we do our job","5","ESSAY");
		Question question10=new Question(10,27,"dog loves","Scratches","boops","food","bath","A,B,C","5","SELECT_ALL");
		Question question11=new Question(11,27,"What is the Ph value of human blood?","7.40","7","0","8","A","5","MCQ");
		Question question12=new Question(12,27,"cherry is female dog","True","False","NaN","NaN","A","5","TRUE_FALSE");
		
		Question question13=new Question(13,36,"What is the Ph value of human blood?","7.40","7","0","8","A","5","MCQ");
		Question question14=new Question(14,37,"cherry is female dog","True","False","NaN","NaN","A","5","TRUE_FALSE");
		Question question15=new Question(15,36,"Write about HR","NaN","NaN","NaN","NaN","HRs do their job, like we do our job","5","ESSAY");
		Question question16=new Question(16,37,"dog loves","Scratches","boops","food","bath","A,B,C","5","SELECT_ALL");
		Question question17=new Question(17,45,"What is the Ph value of human blood?","7.40","7","0","8","A","5","MCQ");
		Question question18=new Question(18,46,"cherry is female dog","True","False","NaN","NaN","A","5","TRUE_FALSE");
		
		Question question19=new Question(19,54,"What is the Ph value of human blood?","7.40","7","0","8","A","5","MCQ");
		Question question20=new Question(20,55,"cherry is female dog","True","False","NaN","NaN","A","5","TRUE_FALSE");
		Question question21=new Question(21,63,"Write about HR","NaN","NaN","NaN","NaN","HRs do their job, like we do our job","5","ESSAY");
		Question question22=new Question(22,64,"dog loves","Scratches","boops","food","bath","A,B,C","5","SELECT_ALL");
		Question question23=new Question(23,54,"What is the Ph value of human blood?","7.40","7","0","8","A","5","MCQ");
		Question question24=new Question(24,55,"cherry is female dog","True","False","NaN","NaN","A","5","TRUE_FALSE");
		
		List<Question> questions =new ArrayList<>();
		questions.add(question1);
		questions.add(question2);
		questions.add(question3);
		questions.add(question4);
		questions.add(question5);
		questions.add(question6);
		questions.add(question7);
		questions.add(question8);
		questions.add(question9);
		questions.add(question10);
		questions.add(question11);
		questions.add(question12);
		questions.add(question13);
		questions.add(question14);
		questions.add(question15);
		questions.add(question16);
		questions.add(question17);
		questions.add(question18);
		questions.add(question19);
		questions.add(question20);
		questions.add(question21);
		questions.add(question22);
		questions.add(question23);
		questions.add(question24);
		return questions;
	}
}
