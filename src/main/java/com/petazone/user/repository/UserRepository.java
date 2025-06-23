package com.petazone.user.repository;

import com.petazone.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    // @Query(value = "select * from user_tbl.user_master where username = :param1", nativeQuery = true)
    Optional<UserEntity> findByUsername(String username);


}
