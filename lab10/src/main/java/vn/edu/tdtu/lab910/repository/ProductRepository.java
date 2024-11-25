package vn.edu.tdtu.lab910.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.tdtu.lab910.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
