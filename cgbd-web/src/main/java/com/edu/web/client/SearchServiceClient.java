package com.edu.web.client;

import com.edu.cgbd.pojo.CgbdResult;
import com.edu.cgbd.pojo.MarkdownData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "cgbd-search")
public interface SearchServiceClient {
    @PostMapping(value = "search/contentCommit", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    CgbdResult contentCommit(@RequestBody MarkdownData markdownData);
}
