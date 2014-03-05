package edu.sjsu.cmpe.library.domain;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.*;
public class Review {
	private long id;
	@JsonProperty(required = true)
	@Min(1)
	@Max(5)
	private int rating;
	@JsonProperty(required = true)
	@NotNull(message = "comment cannot be empty")
	private String comment;
	public long getId() { return id; }
	public void setId(long id) { this.id = id; }
	public int getRating() { return rating; }
	public void setRating(int rating) { this.rating = rating; }
	public String getComment() { return comment; }
	public void setComment(String comment) { this.comment = comment; }
} 
