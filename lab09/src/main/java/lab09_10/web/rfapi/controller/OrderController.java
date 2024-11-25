package lab09_10.web.rfapi.controller;

import lab09_10.web.rfapi.model.Orders;
import lab09_10.web.rfapi.model.Product;
import lab09_10.web.rfapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping
    public List<Orders> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Orders getOrderById(@PathVariable int id) {
        return orderService.getOrderById(id);
    }

    @PostMapping
    public Orders createOrderById(@RequestBody Orders order) {
        for(Product product: order.getProductList()) {
            product.setOrders(order);
        }
        return orderService.addOrder(order);
    }

    @PutMapping("/{id}")
    public Orders updateOrderById(@PathVariable int id, @RequestBody Orders order) {
        return orderService.updateOrder(id, order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable int id) {
        orderService.deleteOrder(id);
    }
}
