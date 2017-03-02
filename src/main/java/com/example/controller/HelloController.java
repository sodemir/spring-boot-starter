package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Axe on 24.01.2017.
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Hello world" ;
    }
}
