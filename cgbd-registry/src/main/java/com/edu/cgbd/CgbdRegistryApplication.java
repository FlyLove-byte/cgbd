package com.edu.cgbd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.util.TimeZone;

@SpringBootApplication
@EnableEurekaServer
public class CgbdRegistryApplication {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
        SpringApplication springApplication = new SpringApplication(CgbdRegistryApplication.class);
        springApplication.addListeners(new ApplicationPidFileWriter("pids/cgbd-registry.pid"));
        springApplication.run(args);
    }

}
