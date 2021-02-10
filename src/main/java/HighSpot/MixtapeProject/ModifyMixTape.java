package HighSpot.MixtapeProject;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This is the data model for the incoming Change file
 * @author Parvin Singh
 */
public class ModifyMixTape {

	@JsonProperty("RemovePlaylist")
	Playlist[] RemovePlaylist;
	@JsonProperty("CreatePlaylist")
	Playlist[] CreatePlaylist;
	@JsonProperty("AddSong")
	Playlist[] AddSong;
	
	ModifyMixTape(){
		
	}

	public Playlist[] getRemovePlaylist() {
		return RemovePlaylist;
	}

	public void setRemovePlaylist(Playlist[] removePlaylist) {
		RemovePlaylist = removePlaylist;
	}

	public Playlist[] getCreatePlaylist() {
		return CreatePlaylist;
	}

	public void setCreatePlaylist(Playlist[] createPlaylist) {
		CreatePlaylist = createPlaylist;
	}

	public Playlist[] getAddSong() {
		return AddSong;
	}

	public void setAddSong(Playlist[] addSong) {
		AddSong = addSong;
	}
	
}
