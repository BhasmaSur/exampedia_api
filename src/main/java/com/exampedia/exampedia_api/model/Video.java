package com.exampedia.exampedia_api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name="videos_table")
@Table(name="videos_table")
public class Video {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int videoId;
	private String videoName;
	private String videoDescription;
	private String videoSubject;
	private String videoFileName;
	private String videoFileID;
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
	public Video(int videoId, @NotNull String videoName, @NotNull String videoDescription, @NotNull String videoSubject,
			@NotNull String videoFileName, @NotNull String videoFileID) {
		super();
		this.videoId = videoId;
		this.videoName = videoName;
		this.videoDescription = videoDescription;
		this.videoSubject = videoSubject;
		this.videoFileName = videoFileName;
		this.videoFileID = videoFileID;
	}
	public Video() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
