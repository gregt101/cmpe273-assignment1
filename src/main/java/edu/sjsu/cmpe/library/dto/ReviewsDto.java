package edu.sjsu.cmpe.library.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import edu.sjsu.cmpe.library.domain.Review;

import java.util.ArrayList;

import java.util.List;

//@JsonPropertyOrder(alphabetic = true)
@JsonPropertyOrder({"reviews" ,"links"})
public class ReviewsDto extends LinksDto {
    private List<Review> reviews;

    /**
     * @param book
     */
    public ReviewsDto(List<Review> reviewArray) {
	super();
	this.reviews = reviewArray;
    }

    /**
     * @return the review
     */
    public List<Review> getReviews() {
	return reviews;
    }

    /**
     * @param review
     *            the review to set
     */
    public void setReviews(List<Review> reviewArray) {
	this.reviews = reviewArray;
    }
    
}
