package com.kt.sym.cart.services.client;

import com.fasterxml.jackson.databind.JsonNode;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@FeignClient(value = "cartCalculatorClient",
        url = "cart-calculator:8080")
public interface CartCalculatorClient {

    @RequestMapping(method = POST, value = "/calculateCart", produces = APPLICATION_JSON_VALUE,
            consumes = APPLICATION_JSON_VALUE)
    @Headers("Content-Type: " + APPLICATION_JSON_VALUE)
    String calculateCart(@RequestParam("grant_type") String grantType,
                    @RequestParam("client_id") String clientId,
                    @RequestBody JsonNode cart);

}