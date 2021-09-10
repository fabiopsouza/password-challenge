package br.com.itau.password.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger configurations
 * @author Fábio Souza
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/** A {@link Docket} config bean */
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("br.com.itau.password"))              
          .paths(PathSelectors.any())                          
          .build()
          .apiInfo(createMetaInfo());       
    }

	private ApiInfo createMetaInfo() {
		
		Contact contact = new Contact("Fábio Souza", "https://www.linkedin.com/in/fabiopdsouza", "fabiosouza.web@gmail.com");
		
		return new ApiInfoBuilder()
				.title("Password Challenge")
				.description("Desafio para processo seletivo do Itaú")
				.version("1.0")
				.contact(contact)
				.build();
	}
}
