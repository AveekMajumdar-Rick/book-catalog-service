package microservices.test.bookcatalogservice.model;

public class BookCatalog {

	private String bookId;
	private Integer userId;
	private String bookName;
	private int rating;

	public BookCatalog() {
	}

	public BookCatalog(String bookId, Integer userId, String bookName, int rating) {
		this.bookId = bookId;
		this.userId = userId;
		this.bookName = bookName;
		this.rating = rating;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}
