package com.johnnyb.vt.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class HttpBinService {
    private static final Logger log = LoggerFactory.getLogger(HttpBinService.class);
    // See: https://httpbin.org/#/Dynamic_data
    private static final String base_url = "https://httpbin.org/";
    private final RestClient restClient;

    public HttpBinService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.baseUrl(base_url).build();
    }

    public ResponseEntity<Void> delay(int seconds) {
        ResponseEntity<Void> bodilessEntity = restClient.get()
                .uri("/delay/" + seconds)
                .retrieve()
                .toBodilessEntity();

        log.info("{} on {}", bodilessEntity.getStatusCode(), Thread.currentThread());
        return bodilessEntity;
    }
}
