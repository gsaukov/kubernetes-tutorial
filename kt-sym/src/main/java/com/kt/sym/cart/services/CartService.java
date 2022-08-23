package com.kt.sym.cart.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kt.sym.cart.services.client.CartCalculatorClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CartService {

    @Autowired
    ObjectMapper mapper;

    @Autowired
    CartCalculatorClient client;

    public void calculateCart(UUID cartId) {
        String cartBody = "[{ \"book\": {\"isbn\": \"1447264533\",\"author\": \"Margaret Mitchell\",\"title\": \"Gone with the Wind\",\"synopsis\": null,\"language\": null }, \"links\": [{\"rel\": \"self\",\"href\": \"http://localhost:8081/api/books/1447264533\"} ]},{ \"book\": {\"isbn\": \"0451524934\",\"author\": \"George Orwell\",\"title\": \"1984\",\"synopsis\": null,\"language\": null }, \"links\": [{\"rel\": \"self\",\"href\": \"http://localhost:8081/api/books/0451524934\"} ]}]";
        JsonNode cart = null;
        try {
            cart = mapper.readTree(cartBody);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        client.calculateCart("", "", cart);
    }



}
