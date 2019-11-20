package bookmenu.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 * The persistent class for the book database table.
 * 
 */
@Entity
@Table(name="book")
public class BookDO {

	@Id
	@Column(name = "bookId")
	private int bookId;

	@Column(name = "price")
	private double price;

	
	@Column(name = "publishDate")
	private Date publishDate;

	@Column(name = "title")
	private String title;

	@Column(name = "volume")
	private int volume;

	public BookDO() {
	}

	public int getBookId() {
		return this.bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getPublishDate() {
		return this.publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getVolume() {
		return this.volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

}