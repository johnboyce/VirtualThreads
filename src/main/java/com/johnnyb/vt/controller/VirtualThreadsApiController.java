package com.johnnyb.vt.controller;

import com.johnnyb.vt.service.HttpBinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1")
public class VirtualThreadsApiController {
    private static final Logger log = LoggerFactory.getLogger(VirtualThreadsApiController.class);
    private final HttpBinService httpBinService;

    public VirtualThreadsApiController(HttpBinService httpBinService) {
        this.httpBinService = httpBinService;
    }



    @GetMapping
    public String root() {
        return """
            <html>
                <body>
                    <h2>Virtual Threads</h2>
                    <h3>JIB VERSION DEPLOYED</h3>
                    <h3>Actuator</h3>
                    <h3>INFO</h3>
                </body>
            </html>""";
    }

    @GetMapping("delay/{seconds}")
    public String delay(@PathVariable int seconds) {
        ResponseEntity<Void> delay = httpBinService.delay(seconds);
        log.info("{} on {}", delay.getStatusCode(), Thread.currentThread());
        return Thread.currentThread().toString();
    }


}
