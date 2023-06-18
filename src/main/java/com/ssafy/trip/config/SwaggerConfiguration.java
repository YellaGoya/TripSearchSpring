package com.ssafy.trip.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
//	Swagger-UI 2.x 확인
//	http://localhost[:8080]/swagger-ui.html

	private String version = "V1";
	private String title = "EnjoyTrip API " + version;

	private ApiInfo apiInfo() {
		String descript = "EnjoyTrip API Reference for Developers<br>";
		return new ApiInfoBuilder().title(title).description(descript)
				.contact(new Contact("SSAFY", "https://edu.ssafy.com", "ssafy@ssafy.com")).license("SSAFY License")
				.licenseUrl("ssafy@ssafy.com").version("1.0").build();
	}

	// API마다 구분짓기 위한 설정.
	@Bean
	public Docket mainApi() {
		return getDocket("메인", Predicates.or(PathSelectors.regex("/attr.*")));
	}
	
	@Bean
	public Docket userApi() {
		return getDocket("회원", Predicates.or(PathSelectors.regex("/user.*")));
	}

	@Bean
	public Docket searchApi() {
		return getDocket("게시판", Predicates.or(PathSelectors.regex("/board.*")));
	}
	@Bean
	public Docket commentApi() {
		return getDocket("댓글", Predicates.or(PathSelectors.regex("/comment.*")));
	}
	
	@Bean
	public Docket allApi() {
		return getDocket("전체", Predicates.or(PathSelectors.regex("/*.*")));
	}


	public Docket getDocket(String groupName, Predicate<String> predicate) {
//		List<ResponseMessage> responseMessages = new ArrayList<ResponseMessage>();
//		responseMessages.add(new ResponseMessageBuilder().code(200).message("OK !!!").build());
//		responseMessages.add(new ResponseMessageBuilder().code(500).message("서버 문제 발생 !!!").responseModel(new ModelRef("Error")).build());
//		responseMessages.add(new ResponseMessageBuilder().code(404).message("페이지를 찾을 수 없습니다 !!!").build());
		return new Docket(DocumentationType.SWAGGER_2).groupName(groupName).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.any()).paths(predicate).build();
//				.useDefaultResponseMessages(false)
//				.globalResponseMessage(RequestMethod.GET,responseMessages);
	}

	// swagger ui 설정.
	@Bean
	public UiConfiguration uiConfig() {
		return UiConfigurationBuilder.builder().displayRequestDuration(true).validatorUrl("").build();
	}

}
