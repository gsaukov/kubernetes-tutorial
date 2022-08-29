package com.kt.sym.cart.knative.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kt.sym.cart.knative.services.client.KnativeCartCalculatorClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KnativeCartService {

    @Value("${kt.sym.cart.body}")
    private String defaultCart;

    private final ObjectMapper mapper;
    private final KnativeCartCalculatorClient client;

    public KnativeCartService(ObjectMapper mapper, KnativeCartCalculatorClient client) {
        this.mapper = mapper;
        this.client = client;
    }

    public String calculateCart() throws JsonProcessingException {
        return calculateCart(defaultCart);
    }

    public String calculateCart(String cartBody) throws JsonProcessingException {
        return client.calculateCart("", "", mapper.readTree(cartBody));
    }

}
