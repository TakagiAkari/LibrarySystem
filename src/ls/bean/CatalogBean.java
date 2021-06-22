package ls.bean;

import java.io.Serializable;
import java.sql.Date;

public class CatalogBean implements Serializable {

	long isbn;
	String bookName;
	int category;
	String author;
	String publisher;
	Date publishDay;


	public CatalogBean() {}

	public CatalogBean(long isbn, String bookName, int category, String author, String publisher, Date publishDay) {
		super();
		this.isbn = isbn;
		this.bookName = bookName;
		this.category = category;
		this.author = author;
		this.publisher = publisher;
		this.publishDay = publishDay;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublishDay() {
		return publishDay;
	}

	public void setPublishDay(Date publishDay) {
		this.publishDay = publishDay;
	}
}
