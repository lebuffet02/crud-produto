package com.example.project.crud.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class Swagger {

    @Value("${swagger.nome}")
    String nome;
    @Value("${swagger.descricao}")
    String descricao;
    @Value("${swagger.versao}")
    String versao;

    @Bean
    public Docket detalheApi() {   //http://localhost:8091/swagger-ui.html#/
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, responseMessages())
                .apiInfo(informacoesApi());
    }

    private List<ResponseMessage> responseMessages() {
        return new ArrayList<>() {{
            add(new ResponseMessageBuilder()
                    .code(500)
                    .message("500 Erro Interno")
                    .build());
            add(new ResponseMessageBuilder()
                    .code(403)
                    .message("Forbidden! (Sem permissão)")
                    .build());
        }};
    }

    private ApiInfo informacoesApi() {
        return new ApiInfoBuilder()
                .title(this.nome)
                .description(this.descricao)
                .version(this.versao)
                .build();
    }
}
