package com.johnnyb.vt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("virtual")
public class VirtualThreadsController {
    public VirtualThreadsController() {
    }

    @GetMapping("hi")
    public String hi (){
        return "Virtual Threads";
    }
}
