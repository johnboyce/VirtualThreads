package com.johnnyb.vt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VirtualThreadsController {
    public VirtualThreadsController() {
    }

    @GetMapping
    public String root() {
        return "JOHNNY B Virtual Threads";
    }

    @GetMapping("hi")
    public String hi() {
        return "Virtual Threads";
    }
}
