package edu.sjsu.cmpe.library.domain;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Random;

public class Author {

   // Random randomGenerator = new Random();
    private long id; // = randomGenerator.nextInt(1000);;
    
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
