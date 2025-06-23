package com.petazone.user.service;

import com.petazone.user.dto.request.CreateUserRequestDTO;
import com.petazone.user.entity.UserEntity;
import com.petazone.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<UserEntity> getUserById() {
        Optional<UserEntity> result = userRepository.findById(1);
        List<UserEntity> response = new ArrayList<>();
        result.ifPresent(response::add);
        return response;
    }

    public UserEntity saveUser(CreateUserRequestDTO userRequestDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userRequestDTO.getUserName());
        userEntity.setEmail(userRequestDTO.getEmail());
        userEntity.setFullName(userRequestDTO.getFullName());
        userEntity.setPasswordHash(userRequestDTO.getPasswordHash());
        return userRepository.save(userEntity);
    }
}
