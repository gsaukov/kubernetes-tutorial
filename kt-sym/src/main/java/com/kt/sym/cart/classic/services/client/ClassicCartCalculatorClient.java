package com.kt.sym.cart.classic.services.client;

import com.fasterxml.jackson.databind.JsonNode;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@FeignClient(value = "classicCartCalculatorClient",
        url = "${feign.client.config.classicCartCalculatorClient.url}")
public interface ClassicCartCalculatorClient {

    @RequestMapping(method = POST, value = "api/calculateCart", produces = APPLICATION_JSON_VALUE,
            consumes = APPLICATION_JSON_VALUE)
    @Headers("Content-Type: application/json")
    String calculateCart(@RequestParam("grant_type") String grantType,
                    @RequestParam("client_id") String clientId,
                    @RequestBody JsonNode cart);

}