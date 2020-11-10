package microservices.test.bookcatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import microservices.test.bookcatalogservice.service.BookCatalogService;

@SpringBootApplication
@EnableEurekaClient
public class BookCatalogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookCatalogServiceApplication.class, args);
	}

	@Bean
	public WebClient.Builder clientBuilder(){
		return  WebClient.builder();
	}
	
	@Bean
	public BookCatalogService BookCatalogService() {
		return new BookCatalogService();
	}
	
}
