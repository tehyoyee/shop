package tehyoyee.github.shop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;
import tehyoyee.github.shop.constant.Role;
import tehyoyee.github.shop.dto.MemberFormDto;

import javax.persistence.*;

@Entity
@Table(name = "member")
@Getter
@Setter
@ToString
public class Member {

	@Id
	@Column(name = "member_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	@Column(unique = true)  // 동일값 방지
	private String email;

	private String password;

	private String address;

	@Enumerated(EnumType.STRING)    // ENUM의 순서가 바뀔경우 문제가 생기므로 String 타입으로 저장
	private Role role;

	public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {
		Member member = new Member();
		member.setName(memberFormDto.getName());
		member.setEmail(memberFormDto.getEmail());
		member.setAddress(memberFormDto.getAddress());
		String password = passwordEncoder.encode(memberFormDto.getPassword());
		member.setPassword(password);
		member.setRole(Role.USER);
		return member;
	}
}
