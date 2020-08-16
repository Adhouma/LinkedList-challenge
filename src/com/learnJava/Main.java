package com.learnJava;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
	/**
	 * Create a program that implements a playlist for songs Create a Song class 
	 * having Title and Duration for a song.
	 * 
	 * The program will have an Album class containing a list of songs. 
	 * The albums will be stored in an ArrayList Songs from different albums 
	 * can be added to the playlist and will appear in the list in the order they are added. 
	 * 
	 * Once the songs have been added to the playlist, create a menu of options to: 
	 * - Quit 
	 * - Skip forward to the next song
	 * - Skip backwards to a previous song. 
	 * - Replay the current song. 
	 * - List the songs in the playlist
	 *  
	 * A song must exist in an album before it can be added to the playlist 
	 * (so you can only play songs that you own). 
	 * 
	 * Hint: 
	 * To replay a song, consider what happened when we went back and forth from a city before
	 * we started tracking the direction we were going. 
	 * As an optional extra provide an option to remove the current song from the playlist 
	 * (hint: listiterator.remove()
	 */
	public static void main(String[] args) {

		Album rapAlbum = new Album("Rap Album");
		rapAlbum.addSong("Lose your self", 5.24);
		rapAlbum.addSong("8 Mile", 6.00);
		rapAlbum.addSong("Godzilla", 4.27);
		rapAlbum.addSong("Rap God", 6.10);
		rapAlbum.addSong("Not Afraid", 4.19);

		Album popAlbum = new Album("Pop Album");
		popAlbum.addSong("Happy", 4.10);
		popAlbum.addSong("Shape of you", 4.24);
		popAlbum.addSong("Mama I'm a criminal", 3.55);
		popAlbum.addSong("Let her go", 4.15);
		popAlbum.addSong("Sugar", 5.02);

		Playlist myFavoritePlaylist = new Playlist("My favorite Playlist");
		LinkedList<Song> playlist = myFavoritePlaylist.getPlaylist();
		myFavoritePlaylist.addSong(rapAlbum, "Lose your self");
		myFavoritePlaylist.addSong(rapAlbum, "8 Mile");
		myFavoritePlaylist.addSong(rapAlbum, "Not Afraid");
		myFavoritePlaylist.addSong(popAlbum, "Happy");
		myFavoritePlaylist.addSong(popAlbum, "Mama I'm a criminal");

		printMenu();
		playPlaylist(playlist);

	}

	private static void printPlaylistSongs(LinkedList<Song> playlsit) {
		System.out.println("/*--- Playlist ---*/");
		for (int i = 0; i < playlsit.size(); i++) {
			System.out.println("Song: " + playlsit.get(i).getTitle() + ", Duration: "
					+ String.format("%.2f", playlsit.get(i).getDuration()));
		}
	}

	private static void playPlaylist(LinkedList<Song> playlist) {
		ListIterator<Song> listIterator = playlist.listIterator();
		Scanner scanner = new Scanner(System.in);
		boolean moveForward = true;
		boolean quit = false;

		while (!quit) {
			System.out.println("Choice:");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 0:
				quit = true;
				System.out.println("/*--- Goodbye ---*/");
				break;
			case 1:
				if (moveForward == false) {
					if (listIterator.hasNext()) {
						listIterator.next();
					}
					moveForward = true;
				}
				if (listIterator.hasNext()) {
					System.out.println("Next Track: " + listIterator.next().getTitle());
				} else {
					System.out.println("Reached the end of the playlist");
					moveForward = false;
				}
				break;
			case 2:
				if (moveForward == true) {
					if (listIterator.hasPrevious()) {
						listIterator.previous();
					}
					moveForward = false;
				}
				if (listIterator.hasPrevious()) {
					System.out.println("Previous Track: " + listIterator.previous().getTitle());
				} else {
					System.out.println("You are at the top of the playlist");
					moveForward = true;
				}
				break;
			case 3:
				if (moveForward == true) {
					if (listIterator.hasPrevious()) {
						System.out.println("Current Track: " + listIterator.previous().getTitle());
						moveForward = false;
					} else {
						System.out.println("You are at the top of the playlist");
					}
				} else {
					if (listIterator.hasPrevious()) {
						System.out.println("Current Track: " + listIterator.next().getTitle());
						moveForward = false;
					} else {
						System.out.println("Reached the end of the playlist\"");
					}
				}
				break;
			case 4:
				printPlaylistSongs(playlist);
				break;
			default:
				printMenu();
			}
		}
		scanner.close();
	}

	private static void printMenu() {
		System.out.println("/*--- Menu ---*/");
		System.out.println("Press: ");
		System.out.println("\t 0- Quit");
		System.out.println("\t 1- Skip forward to the next song");
		System.out.println("\t 2- Skip backwards to a previous song");
		System.out.println("\t 3- Replay the current song");
		System.out.println("\t 4- List the songs in the playlist");
	}

}
