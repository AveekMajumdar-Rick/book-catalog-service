package microservices.test.bookcatalogservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import microservices.test.bookcatalogservice.model.BookCatalog;
import microservices.test.bookcatalogservice.model.BookRatings;

@Service
public class BookCatalogService {

	@Autowired
	private BookRatingService bookRatingService;

	@Autowired
	private BookInfoService bookInfoService;

	public List<BookCatalog> getBookCatalogs(Integer userId) {

		BookRatings ratings = bookRatingService.getBookRating(userId);

		return ratings.getRatings().stream()
				.map(rating -> bookInfoService.getBookCatalog(rating.getRating(), userId, rating.getBookId()))
				.collect(Collectors.toList());
	}
}
