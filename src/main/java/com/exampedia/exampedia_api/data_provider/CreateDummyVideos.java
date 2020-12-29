package com.exampedia.exampedia_api.data_provider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.exampedia.exampedia_api.model.Video;

@Component
public class CreateDummyVideos {

	
	public CreateDummyVideos() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<Video> getDummyVideosSet1(){
		
		List<Video> videoSet1= new ArrayList<>();
		Video video1 = new Video(1,"Video1","watch it lol","MPSC","v1.mp4","v123");
		Video video2 = new Video(2,"Video3","watch it lol","MPSC","v1.mp4","v123");
		videoSet1.add(video1);
		videoSet1.add(video2);
		return videoSet1;
	}
	public List<Video> getDummyVideosSet2(){
		
		List<Video> videoSet2= new ArrayList<>();
		Video video3 = new Video(3,"Video3","watch it lol","MPSC","v1.mp4","v123");
		Video video4 = new Video(4,"Video4","watch it lol","MPSC","v1.mp4","v123");
		videoSet2.add(video3);
		videoSet2.add(video4);
		return videoSet2;
	}
}
