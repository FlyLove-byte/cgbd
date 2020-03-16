package com.edu.cgbd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.TimeZone;

@SpringBootApplication
@EnableFeignClients
@ServletComponentScan
@MapperScan(basePackages = "com.edu.cgbd.mapper")
public class CgbdServantApplication {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
        SpringApplication springApplication = new SpringApplication(CgbdServantApplication.class);
        springApplication.addListeners(new ApplicationPidFileWriter("pids/cgbd-servant.pid"));
        springApplication.run(args);
    }
}
