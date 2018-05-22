package com.aiteachu.morinaga.view;

import java.util.ArrayList;
import java.util.List;

public class ImageInfo {
	private String hour;
	private String minute;
	private String second;
	private List<String> c1FileNames;
	private List<String> c2FileNames;
	private List<String> c3FileNames;
	private List<String> c4FileNames;
	
	public boolean isValid(){
		return this.c1FileNames.size() == this.c2FileNames.size()
				&& this.c2FileNames.size() == this.c3FileNames.size()
				&& this.c3FileNames.size() == this.c4FileNames.size();
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getMinute() {
		return minute;
	}

	public void setMinute(String minute) {
		this.minute = minute;
	}

	public String getSecond() {
		return second;
	}

	public void setSecond(String second) {
		this.second = second;
	}

	public List<String> getC1FileNames() {
		return c1FileNames;
	}

	public void setC1FileNames(List<String> c1FileNames) {
		this.c1FileNames = c1FileNames;
	}

	public List<String> getC2FileNames() {
		return c2FileNames;
	}

	public void setC2FileNames(List<String> c2FileNames) {
		this.c2FileNames = c2FileNames;
	}

	public List<String> getC3FileNames() {
		return c3FileNames;
	}

	public void setC3FileNames(List<String> c3FileNames) {
		this.c3FileNames = c3FileNames;
	}

	public List<String> getC4FileNames() {
		return c4FileNames;
	}

	public void setC4FileNames(List<String> c4FileNames) {
		this.c4FileNames = c4FileNames;
	}
	
	public void addContentC1(String value){
		if(this.c1FileNames == null){
			this.c1FileNames = new ArrayList<String>();
		}
		
		this.c1FileNames.add(value);
	}
	
	public void addContentC2(String value){
		if(this.c2FileNames == null){
			this.c2FileNames = new ArrayList<String>();
		}
		
		this.c2FileNames.add(value);
	}
	
	public void addContentC3(String value){
		if(this.c3FileNames == null){
			this.c3FileNames = new ArrayList<String>();
		}
		
		this.c3FileNames.add(value);
	}
	
	public void addContentC4(String value){
		if(this.c4FileNames == null){
			this.c4FileNames = new ArrayList<String>();
		}
		
		this.c4FileNames.add(value);
	}
}