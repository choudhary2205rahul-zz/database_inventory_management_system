package com.management.inventory.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserResponse {

    private long id;
    private String username;
    private String password;
    private Set<RoleResponse> roles;
}
