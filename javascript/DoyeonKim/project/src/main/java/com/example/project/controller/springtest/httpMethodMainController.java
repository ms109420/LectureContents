package com.example.project.controller.springtest;

import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@CommonsLog
public class httpMethodMainController {

    @GetMapping("/mamin")
    public String getMain () {
        log.info("getMain ()");

        return "httpmethod/main";
    }
}
