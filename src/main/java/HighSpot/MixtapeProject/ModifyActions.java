package HighSpot.MixtapeProject;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class to handle the modification for the Playlists
 * 1- Add song to existing playlist
 * 2- Create a new Playlist with atleast one song
 * 3- Delete a playlist belonging to a user
 * @author Parvin Singh
 */
public class ModifyActions {

	//mapping playlistId : playList
	static HashMap<String, Playlist> playlistIdMap = new HashMap<String, Playlist>();
	//mapping userId : List of playlistIds
	static HashMap<String, LinkedList<String>> userPlaylistIdMap = new HashMap<String, LinkedList<String>>();
	
	/**
	 * constructor to initialize mapping between the
	 * <playlistID> and <playlist>
	 * <userId> and <playlistIds>
	 * @param playlist
	 */
	ModifyActions(Playlist[] playlist){
		for(Playlist pl: playlist) {
			playlistIdMap.put(pl.getId(), pl);
			
			LinkedList<String> values = userPlaylistIdMap.getOrDefault(pl.getUser_id(), new LinkedList<String>());
			values.add(pl.getId());
			userPlaylistIdMap.put(pl.getUser_id(), values);
		}
	}
	

	/**
	 * Add songs to an existing playlist.
	 * The input contains the playlistId that it needs to modify,
	 * and a list of songIds.
	 * Go over the playlists in Change file, and if there is a playlistID
	 * in the current MixTape, then add the songs to that playlist.
	 * If there is no PlaylistID existing, then just create a new Playlist.
	 * @param playlists 
	 */
	public void AddSong(Playlist[] playlists) {
		if(playlists == null) {
			return;
		}
		for(Playlist newpl: playlists) {
			if(playlistIdMap.containsKey(newpl.getId())) {
				Playlist p = playlistIdMap.get(newpl.getId());
				List<String> songs = Arrays.asList(p.getSong_ids());
				List<String> newSongs = Arrays.asList(newpl.getSong_ids());
				
				List<String> newList = Stream.concat(songs.stream(), newSongs.stream())
                        .collect(Collectors.toList());
				
				p.setSong_ids(newList.toArray(new String[0]));
			}else {
				//if the playlist does not exist, just create one
				createOnePlaylist(newpl);
			}
		}
	}
	
	/**
	 * Removed playlist by UserId.
	 * Enhancement to this could be, remove by PlaylistID,
	 * AND remove all playlists that have a particular Song (only with higher privilege access)
	 * @param playlists
	 */
	public void Remove(Playlist[] playlists) {
		if(playlists == null) {
			return;
		}
		for(Playlist pl: playlists) {
			if(pl.getUser_id() != null) {
				List<String> plIds = userPlaylistIdMap.remove(pl.getUser_id());
				for(String s : plIds) {
					playlistIdMap.remove(s);
				}
			}
		}
	}
	
	/**
	 * Create new playlists with provided list of UserSongs and UserId.
	 * No playlist is created if both userid and SongIds is not provided.
	 * @param playlists
	 */
	public void Create(Playlist[] playlists) {
		if(playlists == null) {
			return;
		}
		//filter out any playlist that does not have a song or a userId
		//we can put log statements with WARN, not ERROR.
		Arrays.stream(playlists)
					.filter(p -> (p.getUser_id()!=null && p.getSong_ids()!=null))
					.toArray();
		
		for(Playlist pl: playlists) {
			createOnePlaylist(pl);
		}
	}


	/*
	 * Creates one Playlist and puts it in the map.
	 */
	private void createOnePlaylist(Playlist pl) {
		pl.setId(generateId());
		playlistIdMap.put(pl.getId(), pl);
	}
		
	//This generates a uniqueID for the playlist.
	//In a distributed world - this should be coming from an ID generation service
	private String generateId() {
		Random r = new Random();
		
		int newId = r.nextInt(101)+1;
		while(playlistIdMap.containsKey(newId)) {
			newId = r.nextInt(101)+1;
		}
		return String.valueOf(newId);
	}
	
	/**
	 * returns all the values from the PlayListId map.
	 * @return array of Playlist
	 */
	public Playlist[] getUpdatedList() {
		Collection<Playlist> values = playlistIdMap.values();
	    return values.toArray(new Playlist[0]);
	}
	
}
