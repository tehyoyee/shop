package tehyoyee.github.shop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "cart")
@Getter @Setter
@ToString
public class Cart {

	@Id
	@Column(name = "cart_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne     // Member 엔티티와 일대일 매핑
	@JoinColumn(name = "member_id")     // 매핑할 외래키를 찾는다. name 이 자동생성되지만, 이상하게 생성될 수 있으니 직접 정함
	private Member member;

}
