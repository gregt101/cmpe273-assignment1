package edu.sjsu.cmpe.library.repository;

import edu.sjsu.cmpe.library.domain.Book;

import edu.sjsu.cmpe.library.domain.Author;

import edu.sjsu.cmpe.library.domain.Review;

/**
 * Book repository interface.
 * 
 * What is repository pattern?
 * 
 * @see http://martinfowler.com/eaaCatalog/repository.html
 */
public interface BookRepositoryInterface {
    /**
     * Save a new book in the repository
     * 
     * @param newBook
     *            a book instance to be create in the repository
     * @return a newly created book instance with auto-generated ISBN
     */
    Book saveBook(Book newBook);
    
    //Book saveReview(Long isbn, Review review);
    Long saveReview(Long isbn, Review review);

    /**
     * Retrieve an existing book by ISBN
     * 
     * @param isbn
     *            a valid ISBN
     * @return a book instance
     */
    Book getBookByISBN(Long isbn);
     
     /**
     * Drop book by ISBN
     * 
     * @param isbn
     *            
     */
    void dropBookByISBN(Long isbn);
    
    Book updateBook(Long isbn, String status);
}
