package com.edu.cgbd.controller;

import com.edu.cgbd.data.CgbdResultStatus;
import com.edu.cgbd.pojo.CgbdResult;
import com.edu.cgbd.pojo.MarkdownData;
import com.edu.cgbd.utils.EsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.UUID;

@RestController
@Slf4j
public class SearchController {
    @Autowired
    private EsUtil esUtil;

    @PostMapping("/contentCommit")
    CgbdResult contentCommit(@RequestBody MarkdownData markdownData) {

        try {
            esUtil.creatIndex(markdownData);
            return CgbdResult.ok();
        } catch (Exception e) {
            log.error("", e);
            return CgbdResult.build(CgbdResultStatus.Unknown_Error);
        }
    }

    @GetMapping("/contentCommit")
    String getMarkdowns() {
        try {
            esUtil.SearchRequest();
            return "";
        } catch (Exception e) {
            log.error("", e);
            return "";
        }
    }



    @PostMapping("/creatIndex")
    String listAllLanguage() {
        try {
            MarkdownData markdownData = new MarkdownData();
            markdownData.setTag("es");
            markdownData.setTitle("qwew3rfdfdf43t44frgergert4tgerg4");
            markdownData.setDetails("243243543657567452342435435465");
            markdownData.setPublishTime(String.valueOf(System.currentTimeMillis()));
            esUtil.creatIndex(markdownData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    @PostMapping("/getApi")
    MarkdownData getApi() {
        try {
            MarkdownData markdownData = new MarkdownData();
            return esUtil.getApi(markdownData);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
