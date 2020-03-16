package com.edu.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.TimeZone;

@SpringBootApplication
@EnableFeignClients
public class CgbdWebApplication {
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
        SpringApplication springApplication = new SpringApplication(CgbdWebApplication.class);
        springApplication.addListeners(new ApplicationPidFileWriter("pids/cgbd-web.pid"));
        springApplication.run(args);
    }
}
