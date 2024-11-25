package lab09_10.web.rfapi.repository;

import lab09_10.web.rfapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
