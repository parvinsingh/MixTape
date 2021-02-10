package HighSpot.MixtapeProject;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Data Model for the Song
 * @author Parvin Singh
 *
 */
public class Song {

	@JsonProperty("id")
	String id;
	@JsonProperty("artist")
	String artist;
	@JsonProperty("title")
	String title;
	
	public Song() {
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
