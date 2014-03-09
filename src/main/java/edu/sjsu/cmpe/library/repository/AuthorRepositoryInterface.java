package edu.sjsu.cmpe.library.repository;

//import edu.sjsu.cmpe.library.domain.Book;

//import edu.sjsu.cmpe.library.domain.Author;

import edu.sjsu.cmpe.library.domain.Author;

/**
 * Book repository interface.
 * 
 * What is repository pattern?
 * 
 * @see http://martinfowler.com/eaaCatalog/repository.html
 */
public interface AuthorRepositoryInterface {
    /**
     * Save a new author in the repository
     * 
     * @param neAuthor
     *            a author instance to be create in the repository
     * @return a newly created author instance with auto-generated ID
     */
    Author saveAuthor(Author newAuthor);
    
 
    /**
     * Retrieve an existing author by ID
     * 
     * @param id
     *            a valid ID
     * @return a author instance
     */
     Author getAuthorByID(Long id);

}
