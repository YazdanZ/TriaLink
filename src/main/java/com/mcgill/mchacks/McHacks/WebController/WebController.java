package com.mcgill.mchacks.McHacks.WebController;

import org.springframework.web.bind.annotation.*;

@RestController
public class WebController {


    @GetMapping(value = "/test")
    public String test() {
        return "Works";
    }

    @RequestMapping(value = "/max/{value1}/{value2}")
    public String getMax(@PathVariable(name = "value1", required = true) int value1,
                         @PathVariable(name = "value2", required = true) int value2) {
        return "The max value of " + String.valueOf(value1) + " and " + String.valueOf(value2) + " is " + String.valueOf(Math.max(value1, value2));
    }

}