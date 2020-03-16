package com.edu.web.client;

import com.edu.cgbd.pojo.CgbdResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "cgbd-account")
public interface AccountServiceClient {
    @GetMapping(value = "accounts/langs", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    CgbdResult langs();

    @GetMapping(value = "accounts/receptionMenuGroups", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    CgbdResult menuGroups();
}
