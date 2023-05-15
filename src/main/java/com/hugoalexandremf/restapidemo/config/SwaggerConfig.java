package com.hugoalexandremf.restapidemo.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.responses.ApiResponse;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

     @Bean
     public OpenAPI api() {
          return new OpenAPI()
                  .info(new Info().title("rest-api-demo")
                          .description("rest-api-demo description")
                          .version("0.1.0")
                          .termsOfService("Terms of service .....")
                          .contact(new Contact().name("hfernandes@digitalsign.pt")
                                  .email("hfernandes@digitalsign.pt")
                                  .url(""))
                          .license(new License().name("License of API")))
                  .externalDocs(new ExternalDocumentation().url("API license URL"));
     }

     @Bean
     public OpenApiCustomizer openApiCustomiserDefaultResponseMsgs() {
          return openApi -> {
               openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {
                    operation.getResponses()
                            .addApiResponse("400 / 500", new ApiResponse()
                                    .description("Bad request / Internal Server Error")
                                    .content(new Content()
                                            .addMediaType(org.springframework.http.MediaType.APPLICATION_JSON_VALUE, new MediaType()
//                                                    .example(new MessageErrorResource("1","AA"))
                                                    .schema(new Schema()
                                                            .name("Error")
                                                            .$ref("MessageErrorResource")))));
               }));
          };
     }

}
