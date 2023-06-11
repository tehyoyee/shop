package tehyoyee.github.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tehyoyee.github.shop.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
