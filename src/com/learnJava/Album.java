package com.learnJava;

import java.util.ArrayList;

public class Album {

	private String name;
	private ArrayList<Song> album;
	
	public Album(String name) {
		this.name = name;
		this.album = new ArrayList<Song>();
	}

	// Methods
	public void addSong(String title, double duration) {
		this.album.add(new Song(title, duration));
	}
	
	public Song findSong(String title) {
		for(Song song : album) {
			if(song.getTitle().equals(title)) {
				return song;
			}
		}
		return null;
	}
	
	// Getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Song> getAlbum() {
		return album;
	}

	public void setAlbum(ArrayList<Song> album) {
		this.album = album;
	}

}
