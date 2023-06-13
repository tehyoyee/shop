package tehyoyee.github.shop.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userId = "";
		if (authentication != null) {
			userId = authentication.getName();      // 현재 로그인된 사용자 이름을 가져온다
		}
		return Optional.of(userId);
	}
}
