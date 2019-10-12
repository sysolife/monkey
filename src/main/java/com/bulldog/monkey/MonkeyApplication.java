package com.bulldog.monkey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MonkeyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonkeyApplication.class, args);
    }

}
