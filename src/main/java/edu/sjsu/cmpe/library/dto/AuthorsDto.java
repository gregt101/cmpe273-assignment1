package edu.sjsu.cmpe.library.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import edu.sjsu.cmpe.library.domain.Author;

import java.util.ArrayList;

import java.util.List;

@JsonPropertyOrder({"authors" ,"links"})
public class AuthorsDto extends LinksDto {
    private List<Author> authors;

    /**
     * @param author
     */
    public AuthorsDto(List<Author> authorArray) {
	super();
	this.authors = authorArray;
    }

    /**
     * @return the author
     */
    public List<Author> getAuthors() {
	return authors;
    }

    /**
     * @param author
     *            the author to set
     */
    public void setAuthors(List<Author> authorArray) {
	this.authors = authorArray;
    }
    
}
