package com.kt.sym.cart.controller;

import com.kt.sym.cart.services.CartService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/calculate")
    public String createCart(@RequestBody String cart) throws Exception {
        return cartService.calculateCart(cart);
    }

    @GetMapping("/calculateDeafult")
    public String calculateDeafultCart() throws Exception {
        return cartService.calculateCart();
    }

}
