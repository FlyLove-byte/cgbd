package com.edu.web.controller.utils;

import com.edu.web.service.utilService.TranslateService;
import com.edu.web.utils.Translate;
import com.edu.web.utils.TranslateInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TranslateController {
    @Autowired
    TranslateService translateService;

    @GetMapping("/translate")
    @ResponseBody
    public Translate translate(String translateValue, String from){
        return translateService.getTranslateValue(translateValue,from);
    }

    /*使用前端构建json并下载，此接口并没有使用*/
    @PostMapping("/init")
    @ResponseBody
    public boolean exportLang(@RequestBody TranslateInfo translateInfo){
        return translateService.exportInit(translateInfo);
    }

    @PostMapping("/sql")
    @ResponseBody
    public boolean sql(@RequestBody TranslateInfo translateInfo){
        return translateService.exportSql(translateInfo);
    }

    @PostMapping("/html")
    @ResponseBody
    public boolean html(@RequestBody TranslateInfo translateInfo, HttpServletRequest request){
        return translateService.exportHtml(translateInfo);
    }
}
