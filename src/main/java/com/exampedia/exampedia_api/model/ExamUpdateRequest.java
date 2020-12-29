package com.exampedia.exampedia_api.model;

public class ExamUpdateRequest {
	private int examId;
	private String examName;
	private String examDescription;
	private String examSubjects;
	private String examFees;
	private boolean examFree;
	private String examFileName;
	private boolean examSoldSeparately;
	private int examCourseId;
	public ExamUpdateRequest(int examId, String examName, String examDescription, String examSubjects, String examFees,
			boolean examFree, String examFileName, boolean examSoldSeparately, int examCourseId) {
		super();
		this.examId = examId;
		this.examName = examName;
		this.examDescription = examDescription;
		this.examSubjects = examSubjects;
		this.examFees = examFees;
		this.examFree = examFree;
		this.examFileName = examFileName;
		this.examSoldSeparately = examSoldSeparately;
		this.examCourseId = examCourseId;
	}
	public ExamUpdateRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	public boolean isExamFree() {
		return examFree;
	}
	public void setExamFree(boolean examFree) {
		this.examFree = examFree;
	}
	public String getExamFileName() {
		return examFileName;
	}
	public void setExamFileName(String examFileName) {
		this.examFileName = examFileName;
	}
	public boolean isExamSoldSeparately() {
		return examSoldSeparately;
	}
	public void setExamSoldSeparately(boolean examSoldSeparately) {
		this.examSoldSeparately = examSoldSeparately;
	}
	public int getExamCourseId() {
		return examCourseId;
	}
	public void setExamCourseId(int examCourseId) {
		this.examCourseId = examCourseId;
	}
	
}
