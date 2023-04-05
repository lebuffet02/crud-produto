//package com.example.project.crud.api.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import java.util.HashSet;
//import java.util.List;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//
////    @Value("${title.name}")
////    String name;
//
//
//    public SwaggerConfig() {}
//
////    @Bean
////    public Docket api() {
////        return new Docket(DocumentationType.SWAGGER_2)
////                .select()
////                .apis(RequestHandlerSelectors.any())
////                .paths(PathSelectors.any())
////                .build()
////                .apiInfo(getApi());
////
////    }
//
//    //    @Bean
////    public Docket api() {
////        return new Docket(DocumentationType.SWAGGER_2)
////                .select()
////                .apis(RequestHandlerSelectors.basePackage("com.example.project.crud.api.controller"))
////                .paths(PathSelectors.any())
////                .build()
////                .securitySchemes(Collections.singletonList(new BasicAuth("basicAuth")))
////                .securityContexts(Collections.singletonList(SecurityContext.builder().build()));
////    }
//
//    @Bean
//    public Docket detalheApi() {
//        Docket docket = new Docket(DocumentationType.SWAGGER_2);
//
//        docket
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.example.project.crud.api.controller"))
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(this.informacoesApi().build())
//                .consumes(new HashSet<>(List.of("application/json")))
//                .produces(new HashSet<>(List.of("application/json")));
//
//        return docket;
//    }
//
////    private ApiInfo getApi() {
////        return new ApiInfoBuilder()
////                .title(name)
////                .description("descricao")
////                .version("1.0")
////                .build();
////    }
//
//
//    private ApiInfoBuilder informacoesApi() {
//
//        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
//
//        apiInfoBuilder.title("Title - Rest API");
//        apiInfoBuilder.description("API exemplo de uso de Springboot REST API");
//        apiInfoBuilder.version("1.0");
//        apiInfoBuilder.termsOfServiceUrl("Termo de uso: Open Source");
//        apiInfoBuilder.license("");
//        apiInfoBuilder.licenseUrl("");
//
//        return apiInfoBuilder;
//    }
//}
