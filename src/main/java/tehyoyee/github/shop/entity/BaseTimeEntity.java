package tehyoyee.github.shop.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

// EntityListeners : 엔티티를 디비에 적용하기 전 커스텀 콜백을 요청할 수 있는 어노테이션
// AuditingEntityListener.class : Entity 영속성 및 업데이트 에 대한 Auditing 정보를 캡처하는 JPAEntityListener
@EntityListeners(value = {AuditingEntityListener.class})
@MappedSuperclass           // 객체 입장에서 공통 매핑정보가 필요할 때 사용
@Getter @Setter
public abstract class BaseTimeEntity {

	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime regTime;

	@LastModifiedDate
	private LocalDateTime updateTime;

}
