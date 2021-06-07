package com.management.inventory.repository;

import com.management.inventory.entity.Role;
import com.management.inventory.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
