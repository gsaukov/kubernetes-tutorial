package com.kt.sym.cart.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CartService {

    @Autowired
    ObjectMapper mapper;

    public void calculateCart(UUID cartId) {
        String cartBody = "";
        try {
            mapper.readTree(cartBody);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }



}
