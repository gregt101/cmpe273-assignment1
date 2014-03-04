package edu.sjsu.cmpe.library.domain;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;

public class Book {
    private long isbn;
    public long getIsbn() { return isbn; }
    
    @NotNull(message = "title is required! ")
    private String title;
    public String getTitle() { return title; }
    
    @NotNull(message = "publication date is requied! ")
    private String pubDate;
    @JsonProperty("publication-date")
    public String getPubdate() { return pubDate; }
    
    private String lang = "";
    public String getLanguage() { return lang; }
  
    private int numPage = 0;
    @JsonProperty("num-pages")
    public int getNumpage() { return numPage; }
    
    private String stat = "available";
    public String getStatus() { return stat; }

    public void setIsbn(long isbn) {
	this.isbn = isbn;
    }
    
    public void setTitle(String title) {
	this.title = title;
    }
 
    public void setPubdate(String pubDate) {
	this.pubDate = pubDate;
    }

    public void setLanguage(String language) {
	this.language = language.toLowerCase();
    }

    public void setNumpage(int numPage) {
	this.numPage = numPage;
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
