package edu.sjsu.cmpe.library.domain;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import java.util.List;

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
    @JsonProperty("language")
    public String getLanguage() { return lang; }
  
    private int numPage = 0;
    @JsonProperty("num-pages")
    public int getNumpage() { return numPage; }
    
    private String stat = "available";
    @JsonProperty("state")
    public String getStatus() { return stat; }

    private List<Author> authors;
    public  List<Author> getAuthors(){ return authors; }
    public  void setAuthors(List<Author> author) { this.authors = author; }

    public void setIsbn(long isbn) {
	this.isbn = isbn;
    }
    
    public void setTitle(String title) {
	this.title = title;
    }
 
    public void setPubdate(String pubDate) {
	this.pubDate = pubDate;
    }

    public void setLanguage(String lang) {
	this.lang = lang.toLowerCase();
    }

    public void setNumpage(int numPage) {
	this.numPage = numPage;
    }

    public void setStatus(String stat) {
    	if(stat.toLowerCase().contains("available")||
    	   stat.toLowerCase().contains("checked-out")||
    	   stat.toLowerCase().contains("in-queue")||
    	   stat.toLowerCase().contains("lost"))
    	   {
		this.stat = stat.toLowerCase();
    	   }
	else if (stat=="")
	{
	        this.stat = "available";
	}
	else
	{
		this.stat = "error";
	}
    }
    
}
