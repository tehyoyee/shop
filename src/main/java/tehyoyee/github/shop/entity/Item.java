package tehyoyee.github.shop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tehyoyee.github.shop.constant.ItemSellStatus;
import tehyoyee.github.shop.dto.ItemFormDto;

import javax.persistence.*;
import java.time.LocalDateTime;

@javax.persistence.Entity
@Table(name = "item")
@Getter
@Setter
@ToString
public class Item extends BaseEntity {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, length = 50)
	private String itemNm;

	@Column(name = "price", nullable = false)
	private int price;

	@Column(nullable = false)
	private int stockNumber;

	@Lob
	@Column(nullable = false)
	private String itemDetail;

	@Enumerated(EnumType.STRING)
	private ItemSellStatus itemSellStatus;

	private LocalDateTime regTime;

	private LocalDateTime updateTime;

	public void updateItem(ItemFormDto itemFormDto) {
		this.itemNm = itemFormDto.getItemNm();
		this.price = itemFormDto.getPrice();
		this.stockNumber = itemFormDto.getStockNumber();
		this.itemDetail = itemFormDto.getItemDetail();
		this.itemSellStatus = itemFormDto.getItemSellStatus();
	}
}
