package HighSpot.MixtapeProject;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DataModel for the Playlist
 * @author Parvin Singh
 *
 */
public class Playlist {

	@JsonProperty("id")
	String id;
	@JsonProperty("user_id")
	String user_id;
	@JsonProperty("song_ids")
	String[] song_ids;
	
	public Playlist() {
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String[] getSong_ids() {
		return song_ids;
	}
	public void setSong_ids(String[] song_ids) {
		this.song_ids = song_ids;
	}
}
