package tehyoyee.github.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tehyoyee.github.shop.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
