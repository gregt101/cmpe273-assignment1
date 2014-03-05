package edu.sjsu.cmpe.library.domain;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Random;

public class Author {
    Random randomGenerator = new Random();
    private long id = randomGenerator.nextInt(99999999);
    
    @JsonProperty(required = true)
    private String name;
    public String getName() { return name; }

    public long getId()
    {
	return id;
    }

    public void setId(long id)
    {
	this.id = id;
    }
}
