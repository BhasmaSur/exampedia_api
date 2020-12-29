package com.exampedia.exampedia_api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="pdfs_table")
@Table(name="pdfs_table")
public class Pdf {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int pdfId;
	private String pdfName;
	private String pdfDescription;
	private String pdfSubjects;
	private String pdfFileName;
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
	public Pdf() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pdf(int pdfId, String pdfName, String pdfDescription, String pdfSubjects, String pdfFileName) {
		super();
		this.pdfId = pdfId;
		this.pdfName = pdfName;
		this.pdfDescription = pdfDescription;
		this.pdfSubjects = pdfSubjects;
		this.pdfFileName = pdfFileName;
	}
	
	
}
