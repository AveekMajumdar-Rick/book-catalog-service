package microservices.test.bookcatalogservice.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import microservices.test.bookcatalogservice.model.BookCatalog;
import microservices.test.bookcatalogservice.service.BookCatalogService;

@RestController
@RequestMapping("/catalog")
public class BookCatalogController {

	@Autowired
	private BookCatalogService bookCatalogService;

	@RequestMapping("/{userId}")
	public List<BookCatalog> getBookCatalog(@PathVariable("userId") String userId) {

		return Collections.singletonList(new BookCatalog(12, Integer.parseInt(userId), "Catch 22", 4));
	}

}
