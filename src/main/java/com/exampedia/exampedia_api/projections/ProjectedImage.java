package com.exampedia.exampedia_api.projections;

public class ProjectedImage {

	private byte[] picByte;
	private String picType;
	public byte[] getPicByte() {
		return picByte;
	}
	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}
	public String getPicType() {
		return picType;
	}
	public void setPicType(String picType) {
		this.picType = picType;
	}
	public ProjectedImage(byte[] picByte, String picType) {
		super();
		this.picByte = picByte;
		this.picType = picType;
	}
	public ProjectedImage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
