package edu.sjsu.cmpe.library.repository;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.concurrent.ConcurrentHashMap;

//import edu.sjsu.cmpe.library.domain.Book;

import edu.sjsu.cmpe.library.domain.Author;

//import edu.sjsu.cmpe.library.domain.Author;

//import java.util.List;

//import java.util.ArrayList;

public class AuthorRepository implements AuthorRepositoryInterface {
    /** In-memory map to store authors. (Key, Value) -> (rID, Book) */
    private final ConcurrentHashMap<Long, Author> authorInMemoryMap;

    /** Never access this key directly; instead use generateAuthorKey() */
    
    private long authorKey;

    public AuthorRepository(ConcurrentHashMap<Long, Author> authorMap) {
	    checkNotNull(authorMap, "authorMap must not be null for AuthorRepository");
	    authorInMemoryMap = authorMap;
	    authorKey = 10;
    }

   private final Long generateAuthorKey() {
      // increment existing authorKey and return the new value
	    return Long.valueOf(++authorKey);
    }

    @Override
    public Author saveAuthor(Author newAuthor) {
	    checkNotNull(newAuthor, "newAuthor instance must not be null");
	    // Generate new rID
	    Long rID = generateAuthorKey();
	    newAuthor.setId(rID);
	
	    // Finally, save the new author into the map
	    authorInMemoryMap.putIfAbsent(rID, newAuthor);

	    return newAuthor;
    }

    @Override
    public Author getAuthorByID(Long id) {
	    checkArgument(id > 0,
		  "Author ID was %s but expected greater than zero value", id);
	    return authorInMemoryMap.get(id);
    }
}
