package microservices.test.bookcatalogservice.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import microservices.test.bookcatalogservice.model.BookRatings;
import microservices.test.bookcatalogservice.model.Rating;

@Service
public class BookRatingService {

	@Autowired
	private WebClient.Builder webClient;

	@HystrixCommand(fallbackMethod = "getFallBackBookRating")
	public BookRatings getBookRating(Integer userId) {
		return webClient.build().get().uri("http://book-rating-service/rating/" + userId).retrieve()
				.bodyToMono(BookRatings.class).block();
	}

	public BookRatings getFallBackBookRating(Integer userId) {
		BookRatings bookRatings = new BookRatings();
		bookRatings.setRatings(Arrays.asList(new Rating("No book match found", userId, 0)));
		return bookRatings;
	}
}
