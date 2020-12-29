package com.exampedia.exampedia_api.data_provider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.exampedia.exampedia_api.model.Course;
import com.exampedia.exampedia_api.model.Exam;
import com.exampedia.exampedia_api.model.Pdf;
import com.exampedia.exampedia_api.model.Video;

@Component
public class CreateDummyCourses {

	@Autowired
	CreateDummyVideos createDummyVideos;
	
	@Autowired
	CreateDummyPdfs createDummyPdfs;
	
	@Autowired
	CreateDummyExams createDummyExams;
	

	public CreateDummyCourses() {
		
		
	}
	public List<Course> getDummyCoursesSet1(){
		
		
		//=========================dummy exams =============================
		CreateDummyExams dummyExamObj=new CreateDummyExams();
		List<Exam> examSet1=dummyExamObj.getDummyExamsSet1();
		//============================ XXX ==================================
		//=========================dummy pdfs =============================
		CreateDummyPdfs dummyPdfObj=new CreateDummyPdfs();
		List<Pdf> pdfSet1=dummyPdfObj.getDummyPdfSet1();
		//============================ XXX ==================================
		//=========================dummy videos =============================
		CreateDummyVideos createDummyVideos = new CreateDummyVideos();
		List<Video> videoSet1=createDummyVideos.getDummyVideosSet1();
		//============================ XXX ===================================
		List<Course> courseSet1=new ArrayList<>();
		Course course1= new Course(1,"MBBS","anatomy, physiology, phsycology","BBS,BDE,BME","NaN","5000","4","gnshayam pathak, lal kishore",examSet1,pdfSet1,videoSet1);
		Course course2= new Course(2,"BCS","anatomy, physiology, phsycology","BBS,BDE,BME","NaN","5000","4","gnshayam pathak, lal kishore",examSet1,pdfSet1,videoSet1);
		courseSet1.add(course1);
		courseSet1.add(course2);
		return courseSet1;
	}
	public List<Course> getDummyCoursesSet2(){
		//=========================dummy exams =============================
		CreateDummyExams dummyExamObj=new CreateDummyExams();
		List<Exam> examSet2=dummyExamObj.getDummyExamsSet2();
		//============================ XXX ==================================
		//=========================dummy pdfs =============================
		CreateDummyPdfs dummyPdfObj=new CreateDummyPdfs();
		List<Pdf> pdfSet2=dummyPdfObj.getDummyPdfSet2();
		//============================ XXX ==================================
		//=========================dummy videos =============================
		CreateDummyVideos createDummyVideos = new CreateDummyVideos();
		List<Video> videoSet2=createDummyVideos.getDummyVideosSet2();
		//============================ XXX ===================================
		List<Course> courseSet2=new ArrayList<>();
		Course course3= new Course(3,"BE","anatomy, physiology, phsycology","BBS,BDE,BME","NaN","5000","4","gnshayam pathak, lal kishore",examSet2,pdfSet2,videoSet2);
		Course course4= new Course(4,"B TECH","anatomy, physiology, phsycology","BBS,BDE,BME","NaN","5000","4","gnshayam pathak, lal kishore",examSet2,pdfSet2,videoSet2);
		courseSet2.add(course3);
		courseSet2.add(course4);
		return courseSet2;
	}
	
}
