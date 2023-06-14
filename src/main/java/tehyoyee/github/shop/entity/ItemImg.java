package tehyoyee.github.shop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "item_img")
@Getter @Setter
public class ItemImg extends BaseEntity {

	@Id @GeneratedValue
	private Long id;

	private String imgName;

	private String oriImgName;

	private String imgUrl;

	private String repimgYn;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_id")
	private Item item;

	public ItemImg(String imgName, String oriImgName, String imgUrl) {
		this.imgName = imgName;
		this.oriImgName = oriImgName;
		this.imgUrl = imgUrl;
	}

}
