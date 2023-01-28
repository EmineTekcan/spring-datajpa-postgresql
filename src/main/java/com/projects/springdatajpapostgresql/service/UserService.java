package com.projects.springdatajpapostgresql.service;

import com.projects.springdatajpapostgresql.dto.UserDto;
import com.projects.springdatajpapostgresql.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

     UserDto save(UserDto userDto);
     void delete(Long userId);
     List<UserDto> getAll();
     Page<UserDto> getAll(Pageable pageable);
}
