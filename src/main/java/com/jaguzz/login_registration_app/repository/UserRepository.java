package com.jaguzz.login_registration_app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaguzz.login_registration_app.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

}
