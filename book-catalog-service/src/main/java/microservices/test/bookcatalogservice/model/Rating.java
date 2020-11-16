package microservices.test.bookcatalogservice.model;

public class Rating {

	private String bookId;
	private Integer userId;
	private int rating;
	
	public Rating() {
		// TODO Auto-generated constructor stub
	}

	public Rating(String bookId, Integer userId, int rating) {
		this.bookId = bookId;
		this.userId = userId;
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}


}
