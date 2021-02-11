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
import com.exampedia.exampedia_api.model.Question;
import com.exampedia.exampedia_api.model.Video;
import com.exampedia.exampedia_api.model.VideoUpdateRequest;
import com.exampedia.exampedia_api.projections.ProjectedCoaching;
import com.exampedia.exampedia_api.projections.ProjectedCoachingAdmin;
import com.exampedia.exampedia_api.projections.ProjectedQuestion;
import com.exampedia.exampedia_api.repository.CoachingRepository;
import com.exampedia.exampedia_api.repository.CourseRepository;
import com.exampedia.exampedia_api.repository.ExamRepository;
import com.exampedia.exampedia_api.repository.QuestionRepository;

@Service
public class CoachingsDetailService {
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	CoachingRepository coachingRepository;
	
	@Autowired
	QuestionRepository questionRepository;
	
	@Autowired
	ExamRepository examRepository;
	
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
		
		//List<Course> courses=new ArrayList<>();
		//Course course = new Course();
		//courses.add(course);
		Coaching coaching = new Coaching();
		coaching.setCoachingName(coachingData.getName());
		coaching.setCoachingEmail(coachingData.getEmail());
		coaching.setCoachingPassword(coachingData.getPassword());
		coaching.setCoachingMobile(coachingData.getMobile());
		coaching.setCoachingAddress(coachingData.getAddress());
		coaching.setCoachingOwner(coachingData.getOwner());
		coaching.setCoachingPicByte("NaN".getBytes());
		coaching.setCoachingPicType("NaN");
		coaching.setCoachingStars("NaN");
		coaching.setCoachingStatus(1);
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
	public Optional<Coaching> updateCourseDetails(Course courseData,int coachingId) {
		Optional<Coaching> coaching=coachingRepository.findById(coachingId);
		boolean boolCourseAlreadyInDatabase = false;
		Coaching coachingUpdated=coaching.get();
		List<Course> courses=coachingUpdated.getCoachingCourses();
		for(Course course:courses) {
			if(course.getCourseId()==courseData.getCourseId()) {
				course.setCourseDescription(courseData.getCourseDescription());
				course.setCourseName(courseData.getCourseName());
				course.setCourseSyllabus(courseData.getCourseSyllabus());
				course.setCourseSubjects(courseData.getCourseSubjects());
				course.setCourseFees(courseData.getCourseFees());
				course.setCourseHours(courseData.getCourseHours());
				course.setCourseProffessors(courseData.getCourseProffessors());
				boolCourseAlreadyInDatabase=true;
			}
		}
		if(boolCourseAlreadyInDatabase) {
			coachingUpdated.setCoachingCourses(courses);
			return Optional.of(coachingRepository.save(coachingUpdated));
		}
		else {
			Course course=new Course();
			course.setCourseDescription(courseData.getCourseDescription());
			course.setCourseName(courseData.getCourseName());
			course.setCourseSyllabus(courseData.getCourseSyllabus());
			course.setCourseSubjects(courseData.getCourseSubjects());
			course.setCourseFees(courseData.getCourseFees());
			course.setCourseHours(courseData.getCourseHours());
			course.setCourseProffessors(courseData.getCourseProffessors());
			courses.add(course);
			coachingUpdated.setCoachingCourses(courses);
			return Optional.of(coachingRepository.save(coachingUpdated));	
		}

	}
	public int getCoachingIdForCourse(int courseId) {
		//System.out.println("====================================="+courseId+"==================");
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
				examObj.setExamMarks(examUpdateToCourse.getExamMarks());
				examObj.setExamSoldSeparately(examUpdateToCourse.isExamSoldSeparately());
				examObj.setExamTime(examUpdateToCourse.getExamTime());
				boolExamAlreadyInDatabase=true;
				break;
			}
		}
		if(boolExamAlreadyInDatabase) {
			Course courseUpdated=courseRepository.save(course);
			return Optional.of(courseUpdated);
		}
		else {
			Exam exam = new Exam();
			exam.setExamName(examUpdateToCourse.getExamName());
			exam.setExamDescription(examUpdateToCourse.getExamDescription());
			exam.setExamSubjects(examUpdateToCourse.getExamSubjects());
			exam.setExamFees(examUpdateToCourse.getExamFees());
			exam.setExamMarks(examUpdateToCourse.getExamMarks());
			exam.setExamSoldSeparately(examUpdateToCourse.isExamSoldSeparately());
			exam.setExamTime(examUpdateToCourse.getExamTime());
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
			Video video = new Video();
			video.setVideoName(videoUpdateToCourse.getVideoName());
			video.setVideoDescription(videoUpdateToCourse.getVideoDescription());
			video.setVideoSubject(videoUpdateToCourse.getVideoSubject());
			video.setVideoFileID(videoUpdateToCourse.getVideoFileID());
			video.setVideoFileName(videoUpdateToCourse.getVideoFileName());
			boolVideoAlreadyInDatabase=true;
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
			Pdf pdf = new Pdf();
			pdf.setPdfName(pdfUpdateToCourse.getPdfName());
			pdf.setPdfDescription(pdfUpdateToCourse.getPdfDescription());
			pdf.setPdfSubjects(pdfUpdateToCourse.getPdfSubjects());
			pdf.setPdfFileName(pdfUpdateToCourse.getPdfFileName());
			coursePdfs.add(pdf);
			Course courseUpdated=courseRepository.save(course);
			return Optional.of(courseUpdated);
		}
	}
	public int getCourseIdForExam(int id) {
		int courseId=examRepository.getIdOfCourseThisExamBelongsTo(id);
		return courseId;
	}
	public List<Question> saveAllTheQuestions(List<Question> questions){
		return questionRepository.saveAll(questions);
	}
	public List<ProjectedQuestion> getAllTheQuestions(int id){
		//return questionRepository.getQuestionsForExamId(id);
		return questionRepository.findByExamId(id);
	}
	
}
