package microservices.test.bookcatalogservice.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class BookCatalogService {

	@Bean
	public BookCatalogService BookCatalogService() {
		return new BookCatalogService();
	}
}
