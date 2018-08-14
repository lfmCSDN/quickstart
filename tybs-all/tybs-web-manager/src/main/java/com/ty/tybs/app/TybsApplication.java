package com.ty.tybs.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("${scan.packages}")
@MapperScan("com.ty.tybs.web.mapper")
public class TybsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TybsApplication.class, args);
        System.out.println("------------------------------------------------------------------------");
        System.out.println("========================================================================");
        System.out.println("------------------tybsAppliction is successful started up---------------");
        System.out.println("========================================================================");
        System.out.println("------------------------------------------------------------------------");
    }
}
