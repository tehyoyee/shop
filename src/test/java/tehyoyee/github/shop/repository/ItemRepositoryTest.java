package tehyoyee.github.shop.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import tehyoyee.github.shop.constant.ItemSellStatus;
import tehyoyee.github.shop.entity.Item;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class ItemRepositoryTest {

	@Autowired
	ItemRepository itemRepository;

	@Test
	@DisplayName("상품 저장 테스트")
	void createItemTest() {
		Item item = new Item();
		item.setItemNm("상품명");
		item.setPrice(10000);
		item.setStockNumber(100);
		item.setItemDetail("상세 설명");
		item.setItemSellStatus(ItemSellStatus.SELL);
		item.setRegTime(LocalDateTime.now());
		item.setUpdateTime(LocalDateTime.now());
		Item savedItem = itemRepository.save(item);
		System.out.println("savedItem.toString() = " + savedItem.toString());
	}

	void createItemList() {
		for (int i = 1; i <= 10; i++) {
			Item item = new Item();
			item.setItemNm("상품명" + i);
			item.setPrice(10000 + i);
			item.setStockNumber(100);
			item.setItemDetail("상세 설명" + i);
			item.setItemSellStatus(ItemSellStatus.SELL);
			item.setRegTime(LocalDateTime.now());
			item.setUpdateTime(LocalDateTime.now());
			Item savedItem = itemRepository.save(item);
		}
	}

	@Test
	@DisplayName("상품명 조회 테스트")
	void findByNameTest() {
		createItemList();
		List<Item> itemList = itemRepository.findByItemNm("상품명1");
		for (Item item : itemList) {
			System.out.println(item.toString());
		}
	}

	@Test
	@DisplayName("상품명 or 상세설명 조회 테스트")
	void findByItemNmOrDetailTest() {
		this.createItemList();
		List<Item> itemList = itemRepository.findByItemNmOrItemDetail("상품명1", "상세 설명1");
		for (Item item : itemList) {
			System.out.println("item.toString() = " + item.toString());
		}
	}

	@Test
	@DisplayName("가격 less than 조회 테스트")
	void findByPriceLessThan() {
		this.createItemList();
		List<Item> itemList = itemRepository.findByPriceLessThan(10004);
		for (Item item : itemList) {
			System.out.println("item.toString() = " + item.toString());
		}
	}

	@Test
	@DisplayName("가격 내림차순 조회 테스트")
	void findByPriceOrderByPriceDesc() {
		this.createItemList();
		List<Item> itemList = itemRepository.findByPriceLessThanOrderByPriceDesc(10004);
		for (Item item : itemList) {
			System.out.println("item.toString() = " + item.toString());
		}
	}

	@Test
	@DisplayName("@Query를 이용한 상품 조회 테스트")
	void findByItemDetailTest() {
		this.createItemList();
		List<Item> itemList = itemRepository.findByItemDetail("상세 설명");
		for (Item item : itemList) {
			System.out.println("item.toString() = " + item.toString());
		}
	}

	@Test
	@DisplayName("nativeQuery 속성을 이용한 상품 조회 테스트")
	void findByItemDetailByNativeTest() {
		this.createItemList();
		List<Item> itemList = itemRepository.findByItemDetailByNative("상세 설명");
		for (Item item : itemList) {
			System.out.println("item.toString() = " + item.toString());
		}
	}
}