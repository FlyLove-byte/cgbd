package com.edu.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/redirect")
public class IndexController {

    @GetMapping("/login")
    public String login() {
        return "backStageLogin";
    }

    @GetMapping("/resume")
    public String resume() {
        return "reception/resume";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/frontend")
    public String frontend() {
        return "reception/frontend";
    }

    @GetMapping("/backend")
    public String backend() {
        return "reception/backend";
    }

    @GetMapping("/translate")
    public String translate(){
        return "utils/translate";
    }

    @GetMapping("/civilServant")
    public String civilServant(){
        return "servant/civilServantBank";
    }

    @GetMapping("/errorSet")
    public String errorSet(){
        return "servant/errorSet";
    }

    @GetMapping("/approval")
    public String approval(){
        return "servant/approvals";
    }

    @GetMapping("/recycleBin")
    public String recycleBin(){
        return "servant/recycleBin";
    }
}
