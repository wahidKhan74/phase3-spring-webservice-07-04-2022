package com.simplilearn.webservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

	@Bean
	public Docket apiDoc() {
		return new Docket(DocumentationType.SWAGGER_2).select()
		.apis(RequestHandlerSelectors.basePackage("com.simplilearn.webservice.contoller"))
		.build().apiInfo(apiInfo());		
	}

	private ApiInfo apiInfo() {
		Contact contact = new Contact("John Smith", "http://joh.smith.com/about", "help@gmail.com");
		return  new  ApiInfo("Ecommerce Products RESTful APIs ", 
				"Ecommerce Products REST API for online store", "1.0.0",
				"Term of service as per user guide lines.", contact, "Apache Lience Version 2.0", 
				"https://www.apache.org/licenses/LICENSE-2.0.html");
	}
}
