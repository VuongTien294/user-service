package tien.baseproject.userservice.config;

//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.ApiKey;
//import springfox.documentation.service.AuthorizationScope;
//import springfox.documentation.service.SecurityReference;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spi.service.contexts.SecurityContext;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.List;

import org.springframework.context.annotation.Configuration;

//@Configuration
//@EnableSwagger2
//@Profile("!prod")
public class SwaggerConfig {
//
//    @Bean
//    public Docket api(@Value("${application.swagger.base-url}") String baseUrl) {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .host(baseUrl)
//                .securityContexts(Arrays.asList(securityContext()))
//                .securitySchemes(Arrays.asList(apiKey()))
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .build()
//                .protocols(new HashSet<>(Arrays.asList("https", "http")))
//                .apiInfo(apiInfo(baseUrl))
//                .useDefaultResponseMessages(false);
//    }
//
//    private ApiInfo apiInfo(String baseUrl) {
//        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
//        apiInfoBuilder.title("REST API");
//        apiInfoBuilder.description(this.buildApiInfoDescription(baseUrl));
//        apiInfoBuilder.version("1.0.0-RELEASE");
//        return apiInfoBuilder.build();
//    }
//
//    private String buildApiInfoDescription(String baseUrl) {
//        StringBuilder sbDesc = new StringBuilder();
//        sbDesc.append("<h4>Building URL</h4>");
//        sbDesc.append("<p>URL = <b>Base URL</b> + endpoint</p>");
//        sbDesc.append("<h4>Note</h4>");
//        sbDesc.append("<ul>");
//        sbDesc.append(
//                "<li>Please remove the redundant slash after <b>Base URL</b> before combine with your selected endpoint.</li>");
//        sbDesc.append("<li>Authorization header value is using \"Bearer\" with access token.</li>");
//        sbDesc.append("<li>[Public] endpoints doesn't need to put <i>Authorization</i> header value.</li>");
//        sbDesc.append("<li>[Secured] endpoints must put <i>Authorization</i> header value.</li>");
//        sbDesc.append("</ul>");
//        sbDesc.append("<h4>Example</h4>");
//        sbDesc.append(
//                "<p>We assumme the base URL is \"https://" + baseUrl
//                        + "/\" and the selected endpoint is \"/public-api/v1.0.0/users/login\"</p>");
//        sbDesc.append("<ul>");
//        sbDesc.append(
//                "<li><b>Right combined URL</b>: https://" + baseUrl + "/public-api/v1.0.0/users/login.</li>");
//        sbDesc.append(
//                "<li><b>Wrong combined URL</b>: https://" + baseUrl + "//public-api/v1.0.0/users/login.</li>");
//        sbDesc.append("</ul>");
//        return sbDesc.toString();
//    }
//
//    private ApiKey apiKey() {
//        return new ApiKey("JWT", "Authorization", "header");
//    }
//
//    private SecurityContext securityContext() {
//        return SecurityContext.builder().securityReferences(defaultAuth()).build();
//    }
//
//    private List<SecurityReference> defaultAuth() {
//        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
//        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//        authorizationScopes[0] = authorizationScope;
//        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
//    }
}
