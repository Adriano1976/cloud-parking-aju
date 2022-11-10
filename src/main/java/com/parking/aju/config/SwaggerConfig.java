package com.parking.aju.config;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Classe responsável por habilitar o Swagger na aplicação.
 * <p>
 * A anotação {@link Component} — Responsavel em informar que essa classe faz parte do servico do Spring.
 * A anotação {@link Configuration} — Responsavel em informar ao Spring que essa classe é uma configuração do Swagger..
 * A anotação {@link EnableSwagger2} — Responsavel em informar ao Spring para ativar o Swagger.
 * A anotação {@link EnableWebMvc} — Responsável por habilitar o processo MVC.
 *
 * @author Adriano Santos
 */
@Component
@Configuration
@EnableWebMvc
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

    /**
     * Metodo responsável por controlar e configurar os caminhos do Swegger e validar a url.
     * <a href="http://localhost:8080/swagger-ui.html">...</a>
     *
     * @param registry Objeto responsavel em receber e manipular os dados da configuracao do Swagger.
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry
                .addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry
                .addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    /**
     * Metodo responsavel por definir os aspecitos dos endpoints expostos por ele.
     *
     * @return Retorna as configurações predefinidas e a url "/swagger-ui.html".
     */
    @Bean
    public Docket getDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.parking.aju"))
                .build()
                .securityContexts(Collections.singletonList(getSecurityContext()))
                .securitySchemes(List.of(basicAuthScheme()));

    }

    private SecurityScheme basicAuthScheme() {
        return new BasicAuth("basicAuth");
    }

    private SecurityContext getSecurityContext() {
        return SecurityContext.builder()
                .securityReferences(List.of(basicAuthReference()))
                .build();
    }

    private SecurityReference basicAuthReference() {
        return new SecurityReference("basicAuth", new AuthorizationScope[0]);
    }

    /**
     * Metodo responsável por controlar, configurar e adicionar algumas informacoes da api.
     *
     * @return Retorna as informacoes da api.
     */
    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("Parking Aju REST API")
                .description("Spring Boot REST API for Parking")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .contact(new Contact("Adriano Santos", "https://github.com/Adriano1976", "adrianosantos.git@gmail.com"))
                .build();
    }

}
