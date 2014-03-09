package edu.sjsu.cmpe.library.repository;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.concurrent.ConcurrentHashMap;

//import edu.sjsu.cmpe.library.domain.Book;

import edu.sjsu.cmpe.library.domain.Review;

//import edu.sjsu.cmpe.library.domain.Author;

//import java.util.List;

//import java.util.ArrayList;

public class ReviewRepository implements ReviewRepositoryInterface {
    /** In-memory map to store reviews. (Key, Value) -> (rID, Book) */
    private final ConcurrentHashMap<Long, Review> reviewInMemoryMap;

    /** Never access this key directly; instead use generateReviewKey() */
    
    private long reviewKey;

    public ReviewRepository(ConcurrentHashMap<Long, Book> reviewMap) {
	    checkNotNull(reviewMap, "reviewMap must not be null for ReviewRepository");
	    reviewInMemoryMap = reviewMap;
	    reviewKey = 10;
    }

   private final Long generateReviewKey() {
      // increment existing reviewKey and return the new value
	    return Long.valueOf(++reviewKey);
    }

    @Override
    public Book saveBook(Review newReview) {
	    checkNotNull(newReview, "newReview instance must not be null");
	    // Generate new rID
	    Long rID = generateReviewKey();
	    newReview.setId(rID);
	
	    // Finally, save the new review into the map
	    reviewInMemoryMap.putIfAbsent(rID, newReview);

	    return newReview;
    }

    @Override
    public Book getReviewByID(Long id) {
	    checkArgument(id > 0,
		  "Review ID was %s but expected greater than zero value", id);
	    return reviewInMemoryMap.get(id);
    }
}
