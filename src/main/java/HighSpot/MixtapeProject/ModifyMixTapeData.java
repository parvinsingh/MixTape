package HighSpot.MixtapeProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class handles the functions that can be done on MixTape data
 * @author Parvin Singh
 */
public class ModifyMixTapeData {
	
	final static String INPUT_FILE = "C:\\Preparation\\CodingPrep\\src\\com\\parvin\\MixtapeProject\\mixtape-data.json";
	final static String CHANGE_FILE = "C:\\Preparation\\CodingPrep\\src\\com\\parvin\\MixtapeProject\\ChangeFile.json";
	final static String RESULT_FILE = "C:\\Preparation\\CodingPrep\\src\\com\\parvin\\MixtapeProject\\output.json";
	static Album mixTapeData = new Album();
	static ObjectMapper mapper = new ObjectMapper();
	static ModifyActions modify;

	/*
	 * Makes any modification to the existing MixTape data
	 * and writes the updated contents into a JSON file 
	 * e.g: update songs in an existing playlist
	 * remove songs from playlist
	 * create playlist from existing songs
	 */
	void modifyData() {
    	try (FileReader reader = new FileReader(CHANGE_FILE))
        {
    		//maps the file contents to a POJO called ModifyMixTape
			ModifyMixTape edits = mapper.readValue(reader, ModifyMixTape.class);
			modify = new ModifyActions(mixTapeData.getPlaylists());
			
			modify.Remove(edits.getRemovePlaylist());
			modify.Create(edits.getCreatePlaylist());
        	modify.AddSong(edits.getAddSong());
        	
        	outputData();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            //exception handling can be logged into a log file
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	/*
	 * Read the input file and map the contents to a POJO
	 */
	void readInput() {
		try (FileReader reader = new FileReader(INPUT_FILE))
        {
			//maps the file contents to the original POJO called Album
			mixTapeData = mapper.readValue(reader, Album.class);
        	
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 
	}
	
	/*
	 * Writes data to an output file
	 */
	void outputData() {
    	try {
    		mixTapeData.setPlaylists(modify.getUpdatedList());
			mapper.writeValue(new File(RESULT_FILE), mixTapeData);
		} catch (Exception e) {
			//possibility of JsonException, OR IOException
			e.printStackTrace();
		}
	}
	
}
