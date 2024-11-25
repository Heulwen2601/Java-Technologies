package vn.edu.tdtu.lab910.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.tdtu.lab910.model.Product;
import vn.edu.tdtu.lab910.repository.ProductRepository;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    // GET: get all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // POST: add a new product
    @PostMapping
    public void createProduct(@RequestBody Product product) {
        productRepository.save(product);
    }

    // GET: get product with id
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id " + id));
    }

    // PUT: replace the entire product
    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable Long id, @RequestBody Product product) {
        return productRepository.findById(id)
                .map(newProduct -> {
                    newProduct.setProductName(product.getProductName());
                    newProduct.setPrice(product.getPrice());
                    newProduct.setDescription(product.getDescription());
                    newProduct.setImage(product.getImage());
                    return productRepository.save(newProduct);
                })
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id " + id));
    }
    // PATCH: Update a product
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productRepository.findById(id)
                .map(updateProduct -> {
                    if (product.getProductName() != null) {
                        updateProduct.setProductName(product.getProductName());
                    }
                    if (product.getPrice() >= 0) {
                        updateProduct.setPrice(product.getPrice());
                    }
                    if (product.getDescription() != null) {
                        updateProduct.setDescription(product.getDescription());
                    }
                    if (product.getImage() != null) {
                        updateProduct.setImage(product.getImage());
                    }
                    return productRepository.save(updateProduct);
                })
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id " + id));
    }

    // DELETE: Delete product based on id
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
}
