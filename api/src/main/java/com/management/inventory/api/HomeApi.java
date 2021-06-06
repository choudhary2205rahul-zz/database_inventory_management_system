package com.management.inventory.api;

import com.management.inventory.model.Authentication;
import com.management.inventory.model.Message;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class HomeApi {

    @GetMapping("/{name}")
    public Message getHome(@PathVariable String name) {
        return new Message("Welcome " + name + " to our Inventory Management Application!");
    }

    @GetMapping("/auth")
    public Authentication getAuth() {
        return new Authentication("Authenticated");
    }
}
