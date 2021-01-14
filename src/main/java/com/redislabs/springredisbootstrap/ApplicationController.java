package com.redislabs.springredisbootstrap;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class ApplicationController {

    @RequestMapping("/healthCheck")
    public String healthCheck() {
        return "I'm alive!";
    }
}
