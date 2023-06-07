package tehyoyee.github.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tehyoyee.github.shop.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

	Member findByEmail(String email);
}
