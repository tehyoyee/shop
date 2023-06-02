package tehyoyee.github.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tehyoyee.github.shop.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
