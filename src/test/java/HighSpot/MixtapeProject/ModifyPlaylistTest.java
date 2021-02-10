package HighSpot.MixtapeProject;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ModifyPlaylistTest {

	static TestData testInputData = new TestData();
	static ObjectMapper mapper = new ObjectMapper();
	
	static {
		try (FileReader reader = new FileReader("C:\\Preparation\\CodingPrep\\src\\com\\parvin\\MixtapeProject\\src\\test\\java\\HighSpot\\MixtapeProject\\TestInput.json"))
        {
			testInputData = mapper.readValue(reader, TestData.class);
        	
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 
	}
	
	@Test
    public void RemovePlayListWithEmptyInput()
    {
        ModifyActions mpl = new ModifyActions(testInputData.getPlaylists());
        int originalSize = testInputData.getPlaylists().length;
        
        mpl.Remove(null);
        assertTrue("nothing changed", originalSize == mpl.getUpdatedList().length);
    }
}
