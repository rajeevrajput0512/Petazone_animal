package com.petazone.user.controller;


import com.petazone.user.auth.JwtTokenUtil;
import com.petazone.user.dto.request.UserLoginRequestDTO;
import com.petazone.user.dto.response.LoginGrantedDTO;
import com.petazone.user.service.CustomUserDetailsService;
import com.petazone.user.utils.ResponseUtils;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/petazone/v1/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService userDetailsService;
    private final JwtTokenUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager,
                          CustomUserDetailsService userDetailsService,
                          JwtTokenUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }


    @PostMapping("/login")
    public ResponseEntity<?> loginRequest(@Valid @RequestBody UserLoginRequestDTO loginRequestDTO) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(), loginRequestDTO.getPassword()));
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequestDTO.getUsername());
        String token = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(ResponseUtils.createSuccessResponse(new LoginGrantedDTO(token)));
    }
}
