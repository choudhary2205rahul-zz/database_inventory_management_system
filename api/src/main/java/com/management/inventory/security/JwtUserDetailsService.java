package com.management.inventory.security;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.management.inventory.entity.User;
import com.management.inventory.model.UserDTO;
import com.management.inventory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

  @Autowired
  private PasswordEncoder bcryptEncoder;
  @Autowired
  private UserRepository userRepository;

  static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

  static {
    inMemoryUserList.add(new JwtUserDetails(1L, "Rahul",
            "$2a$10$3zHzb.Npv1hfZbLEU5qsdOju/tk2je6W6PnNnY.c1ujWPcZh4PL6e", "ROLE_ADMIN"));
    inMemoryUserList.add(new JwtUserDetails(2L, "Choudhary",
            "$2a$10$rhTVwAWiiNdNL6OwTQYqp.oIPae7TSHJUyjs2hjnd5vCaG/ELH3dm", "ROLE_USER"));

  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    User user = userRepository.findByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException("User not found with username: " + username);
    }

    return new JwtUserDetails(user.getId(), user.getUsername(), user.getPassword(),"ROLE_ADMIN");
    /*return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
            new ArrayList<>());*/

     /* // Use DB
      Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
              .filter(user -> user.getUsername().equals(username)).findFirst();

      if (!findFirst.isPresent()) {
        throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
      }

      return findFirst.get();*/
  }

  public User save(UserDTO user) {
    User newUser = new User();
    newUser.setUsername(user.getUsername());
    newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
    return userRepository.save(newUser);
  }

}