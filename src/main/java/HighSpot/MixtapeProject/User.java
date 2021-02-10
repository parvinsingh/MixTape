package HighSpot.MixtapeProject;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DataModel for the User
 * @author Parvin Singh
 *
 */
public class User {

	@JsonProperty("id")
	public String id;
	@JsonProperty("name")
	public String name;
	
	public User() {
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
