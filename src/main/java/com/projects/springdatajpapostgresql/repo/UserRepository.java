package com.projects.springdatajpapostgresql.repo;

import com.projects.springdatajpapostgresql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
