//package com.lambdaschool.zoos.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//
//@Configuration // annotation to tell Spring this is a configuration file
//@EnableSwagger2 // annotation to enable Swagger
//@Import(BeanValidatorPluginsConfiguration.class) // connects our validation constraints to this configuration class
//public class Swagger2Config
//{
//    @Bean
//    public Docket api()
//    {
//        return new Docket(DocumentationType.SWAGGER_2)
//            .select()
//            .apis(RequestHandlerSelectors
//                .basePackage("com.lambdaschool.zoos"))
//            .paths(PathSelectors.regex("/.*"))
//            .build()
//            .apiInfo(apiEndPointsInfo());
//    }
//
//    private ApiInfo apiEndPointsInfo()
//    {
//        return new ApiInfoBuilder().title("Sample Employees Project")
//            .description("A Project Used to Introduce Swagger Documentation")
//            .contact(new Contact("John Mitchell",
//                "http://www.lambdaschool.com",
//                "john@lambdaschool.com"))
//            .license("MIT")
//            .licenseUrl("https://github.com/LambdaSchool/java-sampleemps/blob/master/LICENSE")
//            .version("1.0.0")
//            .build();
//    }
//}
