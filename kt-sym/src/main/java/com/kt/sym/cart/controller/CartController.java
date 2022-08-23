package com.kt.sym.cart.controller;


import com.kt.sym.cart.model.Cart;
import com.kt.sym.cart.services.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/")
    public List<Cart> listCart() {
        return new ArrayList<>();
    }

    @PostMapping("/")
    public Cart createCart(@RequestBody String cart) {
        return new Cart();
    }

    @GetMapping("/{cartId}")
    public Cart getCart(@PathVariable UUID cartId) {
        return new Cart();
    }

    @DeleteMapping("/{cartId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCart(@PathVariable UUID cartId) {
        logger.info("Deleted counter cart id: " + cartId);
    }

    @PostMapping("/{cartId}/calculate")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void calculateCart(@PathVariable UUID cartId) {
        cartService.calculateCart(cartId);
    }


}
