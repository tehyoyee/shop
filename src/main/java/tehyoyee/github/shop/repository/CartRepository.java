package tehyoyee.github.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tehyoyee.github.shop.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
