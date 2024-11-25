package vn.edu.tdtu.lab910.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.tdtu.lab910.model.OrderProducts;
import vn.edu.tdtu.lab910.repository.OrderProductsRepository;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderProductController {
    @Autowired
    private OrderProductsRepository orderProductsRepository;

    // GET: Returns a list of all orders
    @GetMapping
    public List<OrderProducts> getAllOrderProducts() {
        return orderProductsRepository.findAll();
    }

    // POST: Add a new order
    @PostMapping
    public void createOrderProduct(@RequestBody OrderProducts orderProducts) {
        orderProductsRepository.save(orderProducts);
    }

    // GET: Returns the details of an order based on id
    @GetMapping("/{id}")
    public OrderProducts getOrderProductById(@PathVariable Long id) {
        return orderProductsRepository.findById(id).get();
    }

    // PUT: Update an other's informations by id
    @PutMapping("/{id}")
    public OrderProducts updateOrderProductById(@PathVariable Long id, @RequestBody OrderProducts orderProducts) {
        return orderProductsRepository.findById(id)
                .map(orderProduct -> {
                    if (orderProduct.getProduct_list() != null) {
                        orderProduct.setTotal_selling_price(orderProducts.getTotal_selling_price());
                    }
                    orderProduct.setProduct_list(orderProducts.getProduct_list());
                    return orderProductsRepository.save(orderProduct);
        })
                .orElseThrow(() -> new EntityNotFoundException("Order not found with id " + id));
    }

    // DELETE: Delete orders based on id
    @DeleteMapping("/{id}")
    public void deleteOrderProductById(@PathVariable Long id) {
        orderProductsRepository.deleteById(id);
    }
}