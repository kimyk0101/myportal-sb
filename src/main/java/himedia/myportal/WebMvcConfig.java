package himedia.myportal;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import himedia.myportal.interceptors.AuthInterceptor;
import himedia.myportal.interceptors.LogoutInterceptor;

//	mvc 설정 클래스
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	//	인터셉터 설정
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LogoutInterceptor())
			.addPathPatterns("/users/logout");
		
		//	AuthInterceptor
		//	/board/ 하위 모든 URL은 막아두고(인증 걸어두고) 목록만 인증을 거치지 않는다.
		//	즉, Board 서비스에는 기본적으로 로그인이 필요한데 list는 모든 사용자가 열람할 수 있도록 (제한사항에서 빼야 함) 
		registry.addInterceptor(new AuthInterceptor())
			.addPathPatterns("/board/**")
			.excludePathPatterns("/board", "/board/", "/board/list");
	}

	//	정적 자원 Mapping
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/upload-images/**")
			.addResourceLocations("file:/c:/uploads/");
	}
	
	

}
