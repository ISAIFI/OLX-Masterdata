package com.olx;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class OlxMasterdataApplication {

	public static void main(String[] args) {
		SpringApplication.run(OlxMasterdataApplication.class, args);
	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfo("OLX-Masterdata REST API Documentation", 
				"OLX-Master REST APIs released by Zensar Ltd.",
				"1.0",
				"http://zensar.com/termsofservices",
				 new Contact("Aasif", "http://aasif.com", "aasifabrar.khan@zensar.com"),
				 "GPL",
				 "http://gpl.com",
				 new ArrayList<VendorExtension>());
	}

      
	@Bean
	public Docket getCustomizeDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(getApiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.olx"))
				.paths(PathSelectors.ant("/olx/masterdata/**"))
				.build();
	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
