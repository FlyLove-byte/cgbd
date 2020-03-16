package com.edu.cgbd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.TimeZone;

@SpringBootApplication
@EnableFeignClients
@ServletComponentScan
public class CgbdSearchApplication {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
        SpringApplication springApplication = new SpringApplication(CgbdSearchApplication.class);
        springApplication.addListeners(new ApplicationPidFileWriter("pids/cgbd-search.pid"));
        springApplication.run(args);
    }
}
