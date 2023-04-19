package com.fengling;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.fengling.modules.**.mapper")
@SpringBootApplication
public class EsServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsServerApplication.class, args);
    }

}
