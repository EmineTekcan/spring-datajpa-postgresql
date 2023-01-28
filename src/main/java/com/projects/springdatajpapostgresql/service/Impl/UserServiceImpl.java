package com.projects.springdatajpapostgresql.service.Impl;

import com.projects.springdatajpapostgresql.dto.UserDto;
import com.projects.springdatajpapostgresql.entity.Address;
import com.projects.springdatajpapostgresql.entity.User;
import com.projects.springdatajpapostgresql.repo.AddressRepository;
import com.projects.springdatajpapostgresql.repo.UserRepository;
import com.projects.springdatajpapostgresql.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    @Override
    @Transactional
    public UserDto save(UserDto userDto) {

        User user=new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        final User userdb =userRepository.save(user);
        List<Address> addresses=new ArrayList<>();

        userDto.getAddresses().forEach(item ->{
            Address address=new Address();
            address.setAddress(item);
            address.setAddressType(Address.AddressType.OTHER);
            address.setActive(true);
            address.setUser(userdb);
            addresses.add(address);
        });
        addressRepository.saveAll(addresses);
        userDto.setId(userdb.getId());
        return userDto;
    }

    @Override
    public void delete(Long userId) {

    }

    @Override
    public List<UserDto> getAll() {
         List<User> users=userRepository.findAll();
         List<UserDto> userDtos=new ArrayList<>();
         users.forEach(user -> {
             UserDto userDto=new UserDto();
             userDto.setId(user.getId());
             userDto.setName(user.getName());
             userDto.setSurname(user.getSurname());
             userDto.setAddresses(user.getAddresses().stream().map(Address::getAddress).collect(Collectors.toList()));
            userDtos.add(userDto);
         });

         return userDtos;
    }

    @Override
    public Page<UserDto> getAll(Pageable pageable) {
        return null;
    }
}
