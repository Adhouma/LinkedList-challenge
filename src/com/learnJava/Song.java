package com.learnJava;

public class Song {
	
	private String title;
	private double duration;
	
	public Song(String title, double duration) {
		this.title = title;
		this.duration = duration;
	}

	// Getters and Setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}
	
}
