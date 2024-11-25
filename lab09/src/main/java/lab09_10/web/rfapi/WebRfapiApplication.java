package lab09_10.web.rfapi;

import lab09_10.web.rfapi.model.Product;
import lab09_10.web.rfapi.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebRfapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebRfapiApplication.class, args);
	}
	@Bean
	public CommandLineRunner insertProducts(ProductRepository productRepository) {
		return args -> {
			productRepository.save(new Product(1, "Product 1", 19.99, "Brand A", "Red"));
			productRepository.save(new Product(2, "Product 2", 29.99, "Brand B", "Blue"));
			productRepository.save(new Product(3, "Product 3", 39.99, "Brand C", "Green"));
			productRepository.save(new Product(4, "Product 4", 49.99, "Brand D", "Yellow"));
			productRepository.save(new Product(5, "Product 5", 59.99, "Brand E", "Black"));
			productRepository.save(new Product(6, "Product 6", 69.99, "Brand F", "White"));
			productRepository.save(new Product(7, "Product 7", 79.99, "Brand G", "Purple"));
			productRepository.save(new Product(8, "Product 8", 89.99, "Brand H", "Orange"));
			productRepository.save(new Product(9, "Product 9", 99.99, "Brand I", "Gray"));
			productRepository.save(new Product(10, "Product 10", 109.99, "Brand J", "Pink"));
		};
	}

}
