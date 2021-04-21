package com.xzstudio.aystore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xzstudio.aystore.mapper")
public class AyStoreProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(AyStoreProjectApplication.class, args);
    }

}
