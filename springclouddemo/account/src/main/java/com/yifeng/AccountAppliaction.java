package com.yifeng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yifeng.dao")
public class AccountAppliaction {

    public static void main(String[] args) {
        SpringApplication.run(AccountAppliaction.class, args);
    }
}
