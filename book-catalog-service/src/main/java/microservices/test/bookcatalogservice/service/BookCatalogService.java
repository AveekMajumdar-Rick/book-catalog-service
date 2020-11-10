package microservices.test.bookcatalogservice.service;

import java.util.List;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import microservices.test.bookcatalogservice.model.Book;
import microservices.test.bookcatalogservice.model.BookCatalog;
import microservices.test.bookcatalogservice.model.BookRatings;
import reactor.core.publisher.Mono;

@Service
public class BookCatalogService {

	@Autowired
	private WebClient.Builder webClient;

	public List<BookCatalog> getBookCatalogs(Integer userId) {

		Mono<BookRatings> ratings = webClient.build().get().uri("http://localhost:8083/rating/" + userId).retrieve()
				.bodyToMono(BookRatings.class);
		 
		
		return ratings.block().getRatings().stream().map(rating -> {
			Book book = webClient.build().get().uri("http://localhost:8082/master/" + rating.getBookId()).retrieve()
					.bodyToMono(Book.class).block();
			return new BookCatalog(book.getBookId(), userId, book.getBookName(), rating.getRating());
		}).collect(Collectors.toList());
	}
}
