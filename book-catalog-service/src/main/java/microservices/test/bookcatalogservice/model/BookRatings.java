package microservices.test.bookcatalogservice.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookRatings {

	@JsonProperty("user_ratings")
	private List<Rating> ratings;

	
	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	
	
}
