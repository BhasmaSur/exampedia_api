package com.exampedia.exampedia_api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampedia.exampedia_api.model.Coaching;
import com.exampedia.exampedia_api.model.CoachingSignUpRequest;
import com.exampedia.exampedia_api.model.Course;
import com.exampedia.exampedia_api.model.Exam;
import com.exampedia.exampedia_api.model.ExamUpdateRequest;
import com.exampedia.exampedia_api.model.Pdf;
import com.exampedia.exampedia_api.model.PdfUpdateRequest;
import com.exampedia.exampedia_api.model.Video;
import com.exampedia.exampedia_api.model.VideoUpdateRequest;
import com.exampedia.exampedia_api.projections.ProjectedCoaching;
import com.exampedia.exampedia_api.projections.ProjectedCoachingAdmin;
import com.exampedia.exampedia_api.repository.CoachingRepository;
import com.exampedia.exampedia_api.repository.CourseRepository;

@Service
public class CoachingsDetailService {
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	CoachingRepository coachingRepository;
	
	public List<ProjectedCoaching> getAllCoachings(){
		return coachingRepository.findByCoachingStatus(1);
	}
	public ProjectedCoachingAdmin getCoachingByName(String coachingName) {
		return coachingRepository.findByCoachingName(coachingName);
	}
	public Coaching getCoachingByEmail(String email) {
		return coachingRepository.getByCoachingEmail(email);
	}
	public ProjectedCoaching getCoachingById(int coachingId) {
		return coachingRepository.findByCoachingId(coachingId);
	}
	public Coaching getCoachingById2(int coachingId) {
		return coachingRepository.getByCoachingId(coachingId);
	}
	public ProjectedCoachingAdmin findByCoachingEmail(String coachingEmail) {
		return coachingRepository.findByCoachingEmail(coachingEmail);
	}
	public boolean addCoachingIntoDatabase(CoachingSignUpRequest coachingData) {
		
		List<Course> courses=new ArrayList<>();
		Course course = new Course();
		courses.add(course);
		Coaching coaching = new Coaching(
				1,
				coachingData.getName(),
				coachingData.getEmail(),
				coachingData.getPassword(),
				1,
				coachingData.getMobile(),
				coachingData.getAddress(),
				coachingData.getOwner(),
				"NaN",
				"NaN",
				"NaN",
				courses
				);
		Coaching resCoaching = coachingRepository.save(coaching);
		if(resCoaching.getCoachingEmail().matches(coachingData.getEmail())) {
			return true;
		}
		else {
			return false;
		}
	}
	public Optional<Coaching> updateCoachingDetails(Coaching coachingData){
		Coaching coaching=coachingRepository.save(coachingData);
		coaching.setCoachingPassword("NaN");
		return Optional.of(coaching);
	}
	public Optional<Course> updateCourseDetails(Course courseData) {
		Course course=courseRepository.save(courseData);
		return Optional.of(course);
	}
	public int getCoachingIdForCourse(int courseId) {
		int id=courseRepository.getIdOfCoachingThisCourseBelongsTo(String.valueOf(courseId));
		return id;
	}
	public Optional<Course> updateExamDetails(ExamUpdateRequest examUpdateToCourse){
		boolean boolExamAlreadyInDatabase = false;
		Course course=courseRepository.findByCourseId(examUpdateToCourse.getExamCourseId());
		List<Exam> courseExams=course.getCourseExams();
		for (Exam examObj : courseExams) {
			if(examObj.getExamId() == examUpdateToCourse.getExamId()) {
				examObj.setExamName(examUpdateToCourse.getExamName());
				examObj.setExamDescription(examUpdateToCourse.getExamDescription());
				examObj.setExamSubjects(examUpdateToCourse.getExamSubjects());
				examObj.setExamFees(examUpdateToCourse.getExamFees());
				examObj.setExamFree(examUpdateToCourse.isExamFree());
				examObj.setExamSoldSeparately(examUpdateToCourse.isExamSoldSeparately());
				examObj.setExamFileName(examUpdateToCourse.getExamFileName());
				boolExamAlreadyInDatabase=true;
				break;
			}
		}
		if(boolExamAlreadyInDatabase) {
			Course courseUpdated=courseRepository.save(course);
			return Optional.of(courseUpdated);
		}
		else {
			Exam exam = new Exam(examUpdateToCourse.getExamId(),
					examUpdateToCourse.getExamName(),
					examUpdateToCourse.getExamDescription(),
					examUpdateToCourse.getExamSubjects(),
					examUpdateToCourse.getExamFees(),
					examUpdateToCourse.isExamFree(),
					examUpdateToCourse.getExamFileName(),
					examUpdateToCourse.isExamSoldSeparately());
			courseExams.add(exam);
			Course courseUpdated=courseRepository.save(course);
			return Optional.of(courseUpdated);
		}
	}
	public Optional<Course> updateVideoDetails(VideoUpdateRequest videoUpdateToCourse){
		boolean boolVideoAlreadyInDatabase = false;
		Course course=courseRepository.findByCourseId(videoUpdateToCourse.getVideoCourseId());
		List<Video> courseVideos=course.getCourseVideos();
		for (Video videoObj : courseVideos) {
			if(videoObj.getVideoId() == videoUpdateToCourse.getVideoId()) {
				videoObj.setVideoName(videoUpdateToCourse.getVideoName());
				videoObj.setVideoDescription(videoUpdateToCourse.getVideoDescription());
				videoObj.setVideoSubject(videoUpdateToCourse.getVideoSubject());
				videoObj.setVideoFileID(videoUpdateToCourse.getVideoFileID());
				videoObj.setVideoFileName(videoUpdateToCourse.getVideoFileName());
				boolVideoAlreadyInDatabase=true;
				break;
			}
		}
		if(boolVideoAlreadyInDatabase) {
			Course courseUpdated=courseRepository.save(course);
			return Optional.of(courseUpdated);
		}
		else {
			Video video = new Video(videoUpdateToCourse.getVideoId(),
					videoUpdateToCourse.getVideoName(),
					videoUpdateToCourse.getVideoDescription(),
					videoUpdateToCourse.getVideoSubject(),
					videoUpdateToCourse.getVideoFileID(),
					videoUpdateToCourse.getVideoFileName());
			courseVideos.add(video);
			Course courseUpdated=courseRepository.save(course);
			return Optional.of(courseUpdated);
		}
	}
	public Optional<Course> updatePdfDetails(PdfUpdateRequest pdfUpdateToCourse){
		boolean boolPdfAlreadyInDatabase = false;
		Course course=courseRepository.findByCourseId(pdfUpdateToCourse.getPdfCourseId());
		List<Pdf> coursePdfs=course.getCoursePdfs();
		for (Pdf pdfObj : coursePdfs) {
			if(pdfObj.getPdfId() == pdfUpdateToCourse.getPdfId()) {
				pdfObj.setPdfName(pdfUpdateToCourse.getPdfName());
				pdfObj.setPdfDescription(pdfUpdateToCourse.getPdfDescription());
				pdfObj.setPdfSubjects(pdfUpdateToCourse.getPdfSubjects());
				pdfObj.setPdfFileName(pdfUpdateToCourse.getPdfFileName());
				boolPdfAlreadyInDatabase=true;
				break;
			}
		}
		if(boolPdfAlreadyInDatabase) {
			Course courseUpdated=courseRepository.save(course);
			return Optional.of(courseUpdated);
		}
		else {
			Pdf pdf = new Pdf(pdfUpdateToCourse.getPdfId(),
					pdfUpdateToCourse.getPdfName(),
					pdfUpdateToCourse.getPdfDescription(),
					pdfUpdateToCourse.getPdfSubjects(),
					pdfUpdateToCourse.getPdfFileName());
			coursePdfs.add(pdf);
			Course courseUpdated=courseRepository.save(course);
			return Optional.of(courseUpdated);
		}
	}
	
}
