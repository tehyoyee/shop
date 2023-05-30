package tehyoyee.github.shop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tehyoyee.github.shop.constant.ItemSellStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class Item {

	private Long id;
	private String itemNm;
	private int price;
	private int stockNumber;
	private String itemDetail;
	private ItemSellStatus itemSellStatus;
	private LocalDateTime regTime; //등록 시간
	private LocalDateTime updateTime; //수정 시간

}
