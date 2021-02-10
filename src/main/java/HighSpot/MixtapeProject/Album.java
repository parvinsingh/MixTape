package HighSpot.MixtapeProject;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Data Model to handle the Input JSON file
 * @author Parvin Singh
 */
public class Album {

	@JsonProperty("users")
	User[] users;
	@JsonProperty("playlists")
	Playlist[] playlists;
	@JsonProperty("songs")
	Song[] songs;
	
	public Album() {
		
	}
	
	public User[] getUsers() {
		return users;
	}
	public void setUsers(User[] users) {
		this.users = users;
	}
	public Playlist[] getPlaylists() {
		return playlists;
	}
	public void setPlaylists(Playlist[] playlists) {
		this.playlists = playlists;
	}
	public Song[] getSongs() {
		return songs;
	}
	public void setSongs(Song[] songs) {
		this.songs = songs;
	}
	
}
