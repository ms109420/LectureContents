package com.example.jswithspring.controller.vue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class FirstVueController {

    @GetMapping("/vueIndex")
    public String getVueIndex () {
        log.info("getVueIndex()");

        return "/vue/index";
    }
}
