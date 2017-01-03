package com.xionglindong;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 创建swagger2的配置类
 * @author 熊林栋
 *
 */
//让Spring来加载该类配置
@Configuration
//启用Swagger2
@EnableSwagger2
public class Swagger2 {
	
	@Bean
	public Docket createRestApi(){
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.xionglindong.web"))
				.paths(PathSelectors.any())
				.build();
	}
	
	private ApiInfo apiInfo(){
		return new ApiInfoBuilder()
				.title("嘿嘿嘿")
				.description("还不赶紧关注一波！")
				.termsOfServiceUrl("http://www.weibo.com/xionglindong")
				.contact("你帅气的栋爷")
				.version("1.0.0")
				.build();
	}

}
