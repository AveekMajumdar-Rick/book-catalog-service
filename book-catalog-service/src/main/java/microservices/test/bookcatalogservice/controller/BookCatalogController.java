package microservices.test.bookcatalogservice.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import microservices.test.bookcatalogservice.model.BookCatalog;
import microservices.test.bookcatalogservice.service.BookCatalogService;

@RestController
@RequestMapping(value = "/catalog", produces = MediaType.APPLICATION_JSON)
public class BookCatalogController {

	@Autowired
	private BookCatalogService bookCatalogService;

	@RequestMapping("/{userId}")
	public List<BookCatalog> getBookCatalog(@PathVariable("userId") String userId) {

		return bookCatalogService.getBookCatalogs(Integer.parseInt(userId));
	}

}
