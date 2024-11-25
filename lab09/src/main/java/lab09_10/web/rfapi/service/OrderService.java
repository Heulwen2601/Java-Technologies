package lab09_10.web.rfapi.service;

import lab09_10.web.rfapi.model.Orders;
import lab09_10.web.rfapi.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }
    public Orders getOrderById(int id) {
        return orderRepository.findById(id).orElse(null);
    }
    public Orders addOrder(Orders order) {
        return orderRepository.save(order);
    }
    public Orders updateOrder(int id, Orders order) {
        Orders order1 = orderRepository.findById(id).orElse(null);
        if (order1 != null) {
            order1.setId(order.getId());
            order1.setDate_created(order.getDate_created());
            order1.setStatus(order.getStatus());
            return orderRepository.save(order1);
        }
        return null;
    }
    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }
}
