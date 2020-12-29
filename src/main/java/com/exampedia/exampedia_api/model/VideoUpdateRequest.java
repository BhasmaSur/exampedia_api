package com.exampedia.exampedia_api.model;

public class VideoUpdateRequest {
	private int videoId;
	private String videoName;
	private String videoDescription;
	private String videoSubject;
	private String videoFileName;
	private String videoFileID;
	private int videoCourseId;
	public int getVideoId() {
		return videoId;
	}
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	public String getVideoName() {
		return videoName;
	}
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	public String getVideoDescription() {
		return videoDescription;
	}
	public void setVideoDescription(String videoDescription) {
		this.videoDescription = videoDescription;
	}
	public String getVideoSubject() {
		return videoSubject;
	}
	public void setVideoSubject(String videoSubject) {
		this.videoSubject = videoSubject;
	}
	public String getVideoFileName() {
		return videoFileName;
	}
	public void setVideoFileName(String videoFileName) {
		this.videoFileName = videoFileName;
	}
	public String getVideoFileID() {
		return videoFileID;
	}
	public void setVideoFileID(String videoFileID) {
		this.videoFileID = videoFileID;
	}
	public int getVideoCourseId() {
		return videoCourseId;
	}
	public void setVideoCourseId(int videoCourseId) {
		this.videoCourseId = videoCourseId;
	}
	public VideoUpdateRequest(int videoId, String videoName, String videoDescription, String videoSubject,
			String videoFileName, String videoFileID, int videoCourseId) {
		super();
		this.videoId = videoId;
		this.videoName = videoName;
		this.videoDescription = videoDescription;
		this.videoSubject = videoSubject;
		this.videoFileName = videoFileName;
		this.videoFileID = videoFileID;
		this.videoCourseId = videoCourseId;
	}
	public VideoUpdateRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
