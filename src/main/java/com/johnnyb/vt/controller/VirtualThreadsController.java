package com.johnnyb.vt.controller;

import com.johnnyb.vt.service.HttpBinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class VirtualThreadsController {
    private static final Logger log = LoggerFactory.getLogger(VirtualThreadsController.class);
    private final HttpBinService httpBinService;

    public VirtualThreadsController(HttpBinService httpBinService) {
        this.httpBinService = httpBinService;
    }

    @GetMapping
    public String root() {
        return "JOHNNY B Virtual Threads";
    }

    @GetMapping("delay/{seconds}")
    public String delay(@PathVariable int seconds) {
        ResponseEntity<Void> delay = httpBinService.delay(seconds);
        log.info("{} on {}", delay.getStatusCode(), Thread.currentThread());
        return Thread.currentThread().toString();
    }


}
