package com.exampedia.exampedia_api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name="exams_table")
@Table(name="exams_table")
public class Exam {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int examId;
	private String examName;
	private String examDescription;
	private String examSubjects;
	private String examFees;
	private String examMarks;
	private String examTime;
	private boolean examSoldSeparately;
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public String getExamDescription() {
		return examDescription;
	}
	public void setExamDescription(String examDescription) {
		this.examDescription = examDescription;
	}
	public String getExamSubjects() {
		return examSubjects;
	}
	public void setExamSubjects(String examSubjects) {
		this.examSubjects = examSubjects;
	}
	public String getExamFees() {
		return examFees;
	}
	public void setExamFees(String examFees) {
		this.examFees = examFees;
	}
	public String getExamMarks() {
		return examMarks;
	}
	public void setExamMarks(String examMarks) {
		this.examMarks = examMarks;
	}
	public String getExamTime() {
		return examTime;
	}
	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}
	public boolean isExamSoldSeparately() {
		return examSoldSeparately;
	}
	public void setExamSoldSeparately(boolean examSoldSeparately) {
		this.examSoldSeparately = examSoldSeparately;
	}
	public Exam(int examId, String examName, String examDescription, String examSubjects, String examFees,
			String examMarks, String examTime, boolean examSoldSeparately) {
		super();
		this.examId = examId;
		this.examName = examName;
		this.examDescription = examDescription;
		this.examSubjects = examSubjects;
		this.examFees = examFees;
		this.examMarks = examMarks;
		this.examTime = examTime;
		this.examSoldSeparately = examSoldSeparately;
	}
	public Exam() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
