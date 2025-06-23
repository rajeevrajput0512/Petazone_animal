package com.petazone.user.service;

import com.petazone.user.dto.UserDetailsImpl;
import com.petazone.user.entity.UserEntity;
import com.petazone.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> normalUser = userRepository.findByUsername(username);
        return new UserDetailsImpl(normalUser.get());
    }
}
