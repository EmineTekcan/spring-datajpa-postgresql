package com.projects.springdatajpapostgresql.repo;

import com.projects.springdatajpapostgresql.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
