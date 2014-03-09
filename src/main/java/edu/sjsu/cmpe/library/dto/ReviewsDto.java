package edu.sjsu.cmpe.library.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import edu.sjsu.cmpe.library.domain.Review;

import java.util.ArrayList;

//import java.util.List;

//@JsonPropertyOrder(alphabetic = true)
@JsonPropertyOrder({"reviews" ,"links"})
public class ReviewsDto extends LinksDto {
    private List<Review> reviews;

    /**
     * @param book
     */
    public ReviewsDto(ArrayList<Review> reviewArray) {
	super();
	this.reviews = reviewArray;
    }

    /**
     * @return the review
     */
    public ArrayList<Review> getReviews() {
	return reviews;
    }

    /**
     * @param review
     *            the review to set
     */
    public void setReviews(ArrayList<Review> reviewArray) {
	this.reviews = reviewArray;
    }
    
}
