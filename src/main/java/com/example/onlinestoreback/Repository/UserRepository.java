package com.example.onlinestoreback.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onlinestoreback.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}