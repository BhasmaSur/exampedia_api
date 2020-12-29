package com.exampedia.exampedia_api.model;

public class PdfUpdateRequest {
	private int pdfId;
	private String pdfName;
	private String pdfDescription;
	private String pdfSubjects;
	private String pdfFileName;
	private int pdfCourseId;
	public int getPdfId() {
		return pdfId;
	}
	public void setPdfId(int pdfId) {
		this.pdfId = pdfId;
	}
	public String getPdfName() {
		return pdfName;
	}
	public void setPdfName(String pdfName) {
		this.pdfName = pdfName;
	}
	public String getPdfDescription() {
		return pdfDescription;
	}
	public void setPdfDescription(String pdfDescription) {
		this.pdfDescription = pdfDescription;
	}
	public String getPdfSubjects() {
		return pdfSubjects;
	}
	public void setPdfSubjects(String pdfSubjects) {
		this.pdfSubjects = pdfSubjects;
	}
	public String getPdfFileName() {
		return pdfFileName;
	}
	public void setPdfFileName(String pdfFileName) {
		this.pdfFileName = pdfFileName;
	}
	public int getPdfCourseId() {
		return pdfCourseId;
	}
	public void setPdfCourseId(int pdfCourseId) {
		this.pdfCourseId = pdfCourseId;
	}
	public PdfUpdateRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PdfUpdateRequest(int pdfId, String pdfName, String pdfDescription, String pdfSubjects, String pdfFileName,
			int pdfCourseId) {
		super();
		this.pdfId = pdfId;
		this.pdfName = pdfName;
		this.pdfDescription = pdfDescription;
		this.pdfSubjects = pdfSubjects;
		this.pdfFileName = pdfFileName;
		this.pdfCourseId = pdfCourseId;
	}
	
}
