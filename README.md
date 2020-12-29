## Swagger2-API-Documentation-example
```java
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.example.controller"))
                .paths(PathSelectors.regex("/.*"))
                .build()
                .tags(new Tag("EmployeeController","Operations pertaining to employee in Employee Management System"))
                .apiInfo(apiEndPointsInfo());

        /*
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build().apiInfo(apiEndPointsInfo());
        */
    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Spring Boot RESTful API example")
                .description("Employee Management RESTful API")
//                .contact(new Contact("Test", "www.example.com","java.example@gmail.com"))
//                .license("Apache 2.0")
//                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0.0")
                .build();
    }
}
```