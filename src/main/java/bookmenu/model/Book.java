package bookmenu.model;

public class Book {

	private long bookId;
	private String title;
	private Double price;
	private Integer volume;
	private String publishDate;

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public String getpublishDate() {
		return publishDate;
	}

	public void setpublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

}
