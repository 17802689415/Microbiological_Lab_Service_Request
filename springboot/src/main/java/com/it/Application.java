package com.it;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@Slf4j
@SpringBootApplication
@MapperScan("com.it.mapper")
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class,args);
    }
}
