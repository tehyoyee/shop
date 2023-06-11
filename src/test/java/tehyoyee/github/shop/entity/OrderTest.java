package tehyoyee.github.shop.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;
import tehyoyee.github.shop.constant.ItemSellStatus;
import tehyoyee.github.shop.repository.ItemRepository;
import tehyoyee.github.shop.repository.OrderRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
class OrderTest {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	ItemRepository itemRepository;

	@PersistenceContext
	EntityManager em;

	public Item createItem() {
		Item item = new Item();
		item.setItemNm("테스트 상품");
		item.setPrice(10000);
		item.setItemDetail("상세설명");
		item.setItemSellStatus(ItemSellStatus.SELL);
		item.setStockNumber(100);
		item.setRegTime(LocalDateTime.now());
		item.setUpdateTime(LocalDateTime.now());
		return item;
	}

	@Test
	@DisplayName("영속성 전이 테스트")
	void cascadeTest() {

		Order order = new Order();

		for (int i = 0; i < 3; i++) {
			Item item = this.createItem();
			itemRepository.save(item);
			OrderItem orderItem = new OrderItem();
			orderItem.setItem(item);
			orderItem.setCount(10);
			orderItem.setOrderPrice(10000);
			orderItem.setOrder(order);
			order.getOrderItems().add(orderItem);
		}

		orderRepository.saveAndFlush(order);
		em.clear();

		Order savedOrder = orderRepository.findById(order.getId())
				.orElseThrow(EntityNotFoundException::new);
		assertEquals(3, savedOrder.getOrderItems().size());
	}
}