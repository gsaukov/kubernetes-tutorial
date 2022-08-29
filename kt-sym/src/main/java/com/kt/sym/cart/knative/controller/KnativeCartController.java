package com.kt.sym.cart.knative.controller;

import com.kt.sym.cart.knative.services.KnativeCartService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/knative/cart")
public class KnativeCartController {

    private final KnativeCartService cartService;

    public KnativeCartController(KnativeCartService cartService) {
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
