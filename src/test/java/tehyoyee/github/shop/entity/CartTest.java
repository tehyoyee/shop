package tehyoyee.github.shop.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;
import tehyoyee.github.shop.dto.MemberFormDto;
import tehyoyee.github.shop.repository.CartRepository;
import tehyoyee.github.shop.repository.MemberRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
class CartTest {
	@Autowired
	CartRepository cartRepository;

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@PersistenceContext
	EntityManager em;

	public Member createMember() {
		MemberFormDto memberFormDto = new MemberFormDto();

		memberFormDto.setEmail("test@email.com");
		memberFormDto.setPassword("1234");
		memberFormDto.setName("아무개");
		memberFormDto.setAddress("서울시");
		return Member.createMember(memberFormDto, passwordEncoder);
	}

	@Test
	@DisplayName("장바구니 회원 엔티티 매핑 조회 테스트")
	void findCartAndMemberTest() {

		Member member = createMember();
		memberRepository.save(member);

		Cart cart = new Cart();
		cart.setMember(member);
		cartRepository.save(cart);

		em.flush();
		em.clear();

		Cart savedCart = cartRepository.findById(cart.getId())
				.orElseThrow(EntityNotFoundException::new);
		assertEquals(savedCart.getMember().getId(), member.getId());
	}
}