package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
//
//	@Autowired
//	MemberService memberService;
//
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.formLogin()
//				.loginPage("/members/login")
//				.defaultSuccessUrl("/")
//				.usernameParameter("email")
//				.failureUrl("/members/login/error")
//				.and()
//				.logout()
//				.logoutRequestMatcher(new AntPathRequestMatcher("/members/logout"))
//				.logoutSuccessUrl("/")
//		;
//
//		http.authorizeRequests()
//				.mvcMatchers("/css/**", "/js/**", "/img/**").permitAll()
//				.mvcMatchers("/", "/members/**", "/item/**", "/images/**").permitAll()
//				.mvcMatchers("/admin/**").hasRole("ADMIN")
//				.anyRequest().authenticated()
//		;
//
//		http.exceptionHandling()
//				.authenticationEntryPoint(new CustomAuthenticationEntryPoint())
//		;
//
//		return http.build();
//	}
//  BCryptPasswordEncoder()함수를 이용하여 비밀번호를 암호화하여 저장한다
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}