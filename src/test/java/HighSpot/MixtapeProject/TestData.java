package HighSpot.MixtapeProject;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestData {

	@JsonProperty("playlists")
	Playlist[] playlists;

	public TestData() {
	}
	
	public Playlist[] getPlaylists() {
		return playlists;
	}

	public void setPlaylists(Playlist[] playlists) {
		this.playlists = playlists;
	}

}
