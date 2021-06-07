package com.management.inventory.api;

import com.management.inventory.model.UserResponse;
import com.management.inventory.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersApi {

    private UserService userService;

    public UsersApi(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponse> findAll () {
        return userService.findAll();
    }
}
