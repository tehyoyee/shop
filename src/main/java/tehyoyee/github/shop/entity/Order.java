package tehyoyee.github.shop.entity;

import lombok.Getter;
import lombok.Setter;
import tehyoyee.github.shop.constant.OrderStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order extends BaseEntity {

	@Id @GeneratedValue
	@Column(name = "order_id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member;

	private LocalDateTime orderDate;

	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderItem> orderItems = new ArrayList<>();

	private LocalDateTime regTime;

	private LocalDateTime updateTime;

}
