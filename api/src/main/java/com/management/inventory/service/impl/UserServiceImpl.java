package com.management.inventory.service.impl;

import com.management.inventory.entity.Role;
import com.management.inventory.entity.User;
import com.management.inventory.model.RoleResponse;
import com.management.inventory.model.UserDTO;
import com.management.inventory.model.UserResponse;
import com.management.inventory.repository.UserRepository;
import com.management.inventory.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserResponse> findAll() {
        List<User> all = userRepository.findAll();

        List<UserResponse> userResponses = new ArrayList<>();

        for (User user: all) {
            UserResponse userResponse = new UserResponse();
            userResponse.setId(user.getId());
            userResponse.setUsername(user.getUsername());

            Set<RoleResponse> roleResponses = new HashSet<>();
            for(Role role: user.getRoles()) {
                RoleResponse roleResponse = new RoleResponse();
                roleResponse.setId(role.getId());
                roleResponse.setName(role.getName());
                roleResponses.add(roleResponse);
            }
            userResponse.setRoles(roleResponses);

            userResponses.add(userResponse);
        }

        return userResponses;
    }
}
