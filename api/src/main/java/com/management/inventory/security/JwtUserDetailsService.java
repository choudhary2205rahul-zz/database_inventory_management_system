package com.management.inventory.security;

import com.management.inventory.entity.Role;
import com.management.inventory.entity.User;
import com.management.inventory.model.UserDTO;
import com.management.inventory.repository.RoleRepository;
import com.management.inventory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class JwtUserDetailsService implements UserDetailsService {

  @Autowired
  private PasswordEncoder bcryptEncoder;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private RoleRepository roleRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    User user = userRepository.findByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException("User not found with username: " + username);
    }

    return new JwtUserDetails(user);
  }

  public User save(UserDTO user) {
    User newUser = new User();
    newUser.setUsername(user.getUsername());
    newUser.setPassword(bcryptEncoder.encode(user.getPassword()));

    Optional<Role> byId = roleRepository.findById(user.getRoles().stream().findFirst().get().getId());
    if (byId.isPresent()) {
      newUser.setRoles(Collections.singleton(byId.get()));
    }

    return userRepository.save(newUser);
  }

}