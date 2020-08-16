package com.learnJava;

import java.util.LinkedList;

public class Playlist {

	private String name;
	private LinkedList<Song> playlist;
	
	public Playlist(String name) {
		this.name = name;
		this.playlist = new LinkedList<Song>();
	}

	// Methods
	public void addSong(Album album, String title) {
		if(album.findSong(title) != null) {
			this.playlist.add(album.findSong(title));
		} else {
			System.out.println("Could not find song " + title + " in " + album + " album");
		}
	}
	
	// Getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LinkedList<Song> getPlaylist() {
		return playlist;
	}

	public void setPlaylist(LinkedList<Song> playlist) {
		this.playlist = playlist;
	}
	
}
