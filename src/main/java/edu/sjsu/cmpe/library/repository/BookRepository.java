package edu.sjsu.cmpe.library.repository;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.concurrent.ConcurrentHashMap;

import edu.sjsu.cmpe.library.domain.Book;

import edu.sjsu.cmpe.library.domain.Review;

import edu.sjsu.cmpe.library.domain.Author;

import java.util.Random;

//import java.io.*;

public class BookRepository implements BookRepositoryInterface {
    /** In-memory map to store books. (Key, Value) -> (ISBN, Book) */
    private final ConcurrentHashMap<Long, Book> bookInMemoryMap;

    /** Never access this key directly; instead use generateISBNKey() */
    
    private long isbnKey;
    
    private long authorKey;
    
    private long reviewKey;
    
    //Random randomGenerator = new Random();

    public BookRepository(ConcurrentHashMap<Long, Book> bookMap) {
	checkNotNull(bookMap, "bookMap must not be null for BookRepository");
	bookInMemoryMap = bookMap;
	//isbnKey = randomGenerator.nextInt(999999999);
	isbnKey = 1000;
	authorKey = 3000;
	reviewKey = 5000;
    }

    /**
     * This should be called if and only if you are adding new books to the
     * repository.
     * 
     * @return a new incremental ISBN number
     */
    private final Long generateISBNKey() {
	// increment existing isbnKey and return the new value
	return Long.valueOf(++isbnKey);
    }
    
    private final Long generateAuthorKey() {
	// increment existing authorKey and return the new value
	return Long.valueOf(++authorKey);
    }
    
    private final Long generateReviewKey() {
	// increment existing reviewKey and return the new value
	return Long.valueOf(++reviewKey);
    }

    /**
     * This will auto-generate unique ISBN for new books.
     */
    @Override
    public Book saveBook(Book newBook) {
	checkNotNull(newBook, "newBook instance must not be null");
	// Generate new ISBN
	Long isbn = generateISBNKey();
	newBook.setIsbn(isbn);
	// TODO: create and associate other fields such as author

	// Finally, save the new book into the map
	bookInMemoryMap.putIfAbsent(isbn, newBook);

	return newBook;
    }
    
    public Long saveReview(Long isbn, List review) {
    	 Book newReview = bookInMemoryMap.get(isbn);
    	 //Long idReview = generateReviewKey();
    	 //newReview.setReviews(review);
    	 newReview.setReviews(review);
    	 bookInMemoryMap.put(isbn, newReview);
    	 //return bookInMemoryMap.get(isbn);
    	 return idReview;
    }

    /**
     * @see edu.sjsu.cmpe.library.repository.BookRepositoryInterface#getBookByISBN(java.lang.Long)
     */
    @Override
    public Book getBookByISBN(Long isbn) {
	checkArgument(isbn > 0,
		"ISBN was %s but expected greater than zero value", isbn);
	return bookInMemoryMap.get(isbn);
    }
   
   // @Override
    public void dropBookByISBN(Long isbn) {
	bookInMemoryMap.remove(isbn);
    }
    
    public Book updateBook(Long isbn, String status) {
    	 Book changeBook = bookInMemoryMap.get(isbn);
    	 changeBook.setStatus(status);
    	 bookInMemoryMap.put(isbn, changeBook);
    	 return bookInMemoryMap.get(isbn);
    }
   
}
