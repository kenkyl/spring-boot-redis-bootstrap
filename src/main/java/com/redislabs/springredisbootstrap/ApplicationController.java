package com.redislabs.springredisbootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class ApplicationController {

    @Autowired
    DataRepository redisRepository;

    @RequestMapping("/healthCheck")
    public String healthCheck() {
        return "I'm alive!";
    }

    @RequestMapping("/get")
    public String get() {
        String res = redisRepository.loadData();
        return res;
    }

    @RequestMapping(value = "/set/{data}")
    public String set(@PathVariable String data) {
        String res = redisRepository.setData(data);
        return res;
    }
}
