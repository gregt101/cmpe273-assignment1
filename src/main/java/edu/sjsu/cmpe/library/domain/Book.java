package edu.sjsu.cmpe.library.domain;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;


public class Book {
    private long isbn;
    @NotNull(message = "title is required! ")
    private String title;
    @JsonProperty("publication-date")
    @NotNull(message = "publication date is requied! ")
    private String pubDate;
    private String language = "";
    @JsonProperty("num-pages")
    private int numPage = 0;
    private String status = "available";

    // add more fields here

    /**
     * @return the isbn
     */
    public long getIsbn() {
	return isbn;
    }

    /**
     * @param isbn
     *            the isbn to set
     */
    public void setIsbn(long isbn) {
	this.isbn = isbn;
    }

    /**
     * @return the title
     */
    public String getTitle() {
	return title;
    }

    /**
     * @param title
     *            the title to set
     */
    public void setTitle(String title) {
	this.title = title;
    }
    
    public String getPubdate() {
	return pubDate;
    }

    public void setPubdate(String pubDate) {
	this.pubDate = pubDate;
    }
    
    public String getLanguage() {
	return language;
    }

    public void setLanguage(String language) {
	this.language = language.toLowerCase();
    }
    
    public int getNumpage() {
	return numPage;
    }

    public void setNumpage(int numPage) {
	this.numPage = numPage;
    }
    
    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
    	if(status.toLowerCase().contains("available")||
    	   status.toLowerCase().contains("checked-out")||
    	   status.toLowerCase().contains("in-queue")||
    	   status.toLowerCase().contains("lost"))
    	   {
		this.status = status.toLowerCase();
    	   }
	else if (status=="")
	{
	        this.status = "available";
	}
	else
	{
		this.status = "error";
	}
    }
    
}
