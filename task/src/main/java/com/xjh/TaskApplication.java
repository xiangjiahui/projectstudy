package com.xjh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author 123
 */
@EnableAsync
@SpringBootApplication
public class TaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskApplication.class, args);
    }

}
