package com.exampedia.exampedia_api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="questions_table")
@Table(name="questions_table")
public class Question {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int questionId;
	private int examId;
	private String statement;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private String answer;
	private String marks;
	private String type;
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public String getStatement() {
		return statement;
	}
	public void setStatement(String statement) {
		this.statement = statement;
	}
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getMarks() {
		return marks;
	}
	public void setMarks(String marks) {
		this.marks = marks;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Question(int questionId, int examId, String statement, String optionA, String optionB, String optionC,
			String optionD, String answer, String marks, String type) {
		super();
		this.questionId = questionId;
		this.examId = examId;
		this.statement = statement;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.answer = answer;
		this.marks = marks;
		this.type = type;
	}
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
