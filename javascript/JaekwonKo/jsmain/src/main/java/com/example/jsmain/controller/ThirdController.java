package com.example.jsmain.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class ThirdController {

    @GetMapping("/checkboxTest")
    public String checkboxTest () {
        log.info("checkboxTest()");

        return "/third/checkbox";
    }

    @GetMapping("/radioTest")
    public String radioTest () {
        log.info("radioTest()");

        return "/third/radio";
    }

    @GetMapping("/formRadioTest")
    public String formRadioTest () {
        log.info("formRadioTest()");

        return "/third/formRadio";
    }

    @GetMapping("/test")
    public String test () {
        log.info("test()");

        return "redirect:/";
    }

    @GetMapping("/numberRangeTest")
    public String numberRangeTest () {
        log.info("numberRangeTest()");

        return "/third/numberRange";
    }

    @GetMapping("/buttonTest")
    public String buttonTest () {
        log.info("buttonTest()");

        return "/third/button";
    }

    @GetMapping("/selectTest")
    public String selectTest () {
        log.info("selectTest()");

        return "/third/select";
    }

    @GetMapping("/optgroupTest")
    public String optgroupTest () {
        log.info("optgroupTest()");

        return "/third/optgroup";
    }
}
