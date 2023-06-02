package tehyoyee.github.shop.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import tehyoyee.github.shop.constant.ItemSellStatus;
import tehyoyee.github.shop.entity.Item;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
class ItemRepositoryTest {

	@Autowired
	ItemRepository itemRepository;

	@Test
	@DisplayName("상품 저장 테스트")
	void createItemTest() {
		Item item = new Item();
		item.setItemNm("아이템 이름");
		item.setPrice(39800);
		item.setStockNumber(100);
		item.setItemDetail("상세 설명");
		item.setItemSellStatus(ItemSellStatus.SELL);
		item.setRegTime(LocalDateTime.now());
		item.setUpdateTime(LocalDateTime.now());
		Item savedItem = itemRepository.save(item);
		System.out.println("savedItem.toString() = 안녕" + savedItem.toString());
	}

}