package com.exampedia.exampedia_api.data_provider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.exampedia.exampedia_api.model.Pdf;

@Component
public class CreateDummyPdfs {
	
	

	public CreateDummyPdfs() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<Pdf> getDummyPdfSet1(){
		List<Pdf> pdfSet1=new ArrayList<>();
		Pdf pdf1=new Pdf(1,"pdf1","pdf works so fine","MATHS,PHYSICS","defaultpdf1.pdf","azcqwDP5");
		Pdf pdf2=new Pdf(2,"pdf2","pdf works so fine","MATHS,PHYSICS","defaultpdf2.pdf","V1bza4R8");
		pdfSet1.add(pdf1);
		pdfSet1.add(pdf2);
		return pdfSet1;
	}
	public List<Pdf> getDummyPdfSet2(){
		List<Pdf> pdfSet2=new ArrayList<>();
		Pdf pdf3=new Pdf(3,"pdf3","pdf works so fine","MATHS,PHYSICS","defaultpdf1.pdf","azcqwDP5");
		Pdf pdf4=new Pdf(4,"pdf4","pdf works so fine","MATHS,PHYSICS","defaultpdf2.pdf","V1bza4R8");
		pdfSet2.add(pdf3);
		pdfSet2.add(pdf4);
		return pdfSet2;
	}
}
