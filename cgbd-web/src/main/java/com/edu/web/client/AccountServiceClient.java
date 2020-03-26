package com.edu.web.client;

import com.edu.cgbd.pojo.CgbdResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "cgbd-account")
public interface AccountServiceClient {
    @GetMapping(value = "accounts/langDetails", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    CgbdResult langDetails();

    @GetMapping(value = "accounts/receptionMenuGroups", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    CgbdResult menuGroups();

    @GetMapping(value = "accounts/globalParameter", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    CgbdResult globalParameterByKey(@RequestParam(value = "key") String key);
}
