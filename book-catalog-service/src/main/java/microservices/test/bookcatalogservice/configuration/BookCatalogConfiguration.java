package microservices.test.bookcatalogservice.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class BookCatalogConfiguration {

	@Bean
	@LoadBalanced
	public WebClient.Builder clientBuilder(){
		return  WebClient.builder();
	}

}
