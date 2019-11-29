package com.wxiaoy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.wxiaoy.pojo")
public class WisdomSchoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(WisdomSchoolApplication.class);
    }

}
