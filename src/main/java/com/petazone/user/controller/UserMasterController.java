package com.petazone.user.controller;


import com.petazone.user.dto.request.CreateUserRequestDTO;
import com.petazone.user.dto.response.ApiResponseCommon;
import com.petazone.user.entity.UserEntity;
import com.petazone.user.service.UserService;
import com.petazone.user.utils.ResponseUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/petazone/v1/user")
public class UserMasterController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUserById")
    public ResponseEntity<ApiResponseCommon<List<UserEntity>>> getAllUsers() {
        List<UserEntity> result = userService.getUserById();
        return ResponseEntity.ok(ResponseUtils.createSuccessResponse(result));
    }

    @PostMapping("/saveUser")
    public ResponseEntity<ApiResponseCommon<UserEntity>> saveUser(@Valid @RequestBody CreateUserRequestDTO userRequestDTO) {
        UserEntity user = userService.saveUser(userRequestDTO);
        return ResponseEntity.ok(ResponseUtils.createSuccessResponse(user));
    }
}
