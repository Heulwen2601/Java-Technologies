package lab09_10.web.rfapi.repository;

import lab09_10.web.rfapi.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Integer> {
}
