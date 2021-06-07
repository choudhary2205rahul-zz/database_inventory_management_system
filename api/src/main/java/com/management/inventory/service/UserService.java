package com.management.inventory.service;

import com.management.inventory.model.UserDTO;
import com.management.inventory.model.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> findAll();

}
