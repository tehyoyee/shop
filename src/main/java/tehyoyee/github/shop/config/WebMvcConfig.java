package tehyoyee.github.shop.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Value("${uploadPath}")      // application.properties의 "uploadPath"를 가져옴
	String uploadPath;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**")   // /images/** url은 uploadPath에 설정한 폴더를 기준을 파일을 읽어온다
				.addResourceLocations(uploadPath);      // 로컬컴퓨터에 저장된 파일을 읽어올 root 경로를 설정
	}
}
