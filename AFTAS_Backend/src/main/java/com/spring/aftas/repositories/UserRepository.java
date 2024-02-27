package com.spring.aftas.repositories;


import com.spring.aftas.entities.User;
import com.spring.aftas.enumuration.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByEmail(String email);
    List<User> findUsersByRole(Role role);
}
