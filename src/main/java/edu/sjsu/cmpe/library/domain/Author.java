package edu.sjsu.cmpe.library.domain;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Author {

    private long id = generateAuthorKey();
    
    private final Long generateAuthorKey() {
    // increment existing authorKey and return the new value
        return Long.valueOf(++id);
    }
    
    @JsonProperty(required = true)
    private String name;
    public String getName() { 
    	return name; 
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }
    
     public void setName(String name) {
	this.name = name;
    }
}
