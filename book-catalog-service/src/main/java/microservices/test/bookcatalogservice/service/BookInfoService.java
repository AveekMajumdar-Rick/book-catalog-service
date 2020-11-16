package microservices.test.bookcatalogservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import microservices.test.bookcatalogservice.model.Book;
import microservices.test.bookcatalogservice.model.BookCatalog;

@Service
public class BookInfoService {

	@Autowired
	private WebClient.Builder webClient;

	@HystrixCommand(fallbackMethod = "getFallBackBookCatalog", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"), // timeout if
																											// service
																											// is taking
																											// more than
																											// 3 seconds
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"), // last 5 no of request to
																							// check
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // will try to send
																									// request after 10
																									// seconds. circuit
																									// breaker will trap
																									// it for 10 seconds
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50") }) // error throw
																								// percentage for
																								// circuit breaker
	public BookCatalog getBookCatalog(int rating, Integer userId, String bookId) {
		Book book = webClient.build().get().uri("http://book-master-service/master/" + bookId).retrieve()
				.bodyToMono(Book.class).block();
		return new BookCatalog(book.getBookId(), userId, book.getBookName(), rating);
	}

	public BookCatalog getFallBackBookCatalog(int rating, Integer userId, String bookId) {
		return new BookCatalog("NA", userId, "No bookName displayed", rating);
	}
}
