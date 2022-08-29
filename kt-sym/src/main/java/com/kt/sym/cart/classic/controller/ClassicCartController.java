package com.kt.sym.cart.classic.controller;

import com.kt.sym.cart.classic.services.ClassicCartService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/classic/cart")
public class ClassicCartController {

    private final ClassicCartService cartService;

    public ClassicCartController(ClassicCartService cartService) {
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
