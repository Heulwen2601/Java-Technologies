package lab09_10.web.rfapi.service;

import lab09_10.web.rfapi.model.Product;
import lab09_10.web.rfapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(int id, Product product) {
        Product product1 =  productRepository.findById(id).orElse(null);
        if (product1 != null) {
            product1.setId(product.getId());
            product1.setName(product.getName());
            product1.setPrice(product.getPrice());
            product1.setColor(product.getColor());
            product1.setBrand(product.getBrand());
            return productRepository.save(product);
        }
        return null;
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}
