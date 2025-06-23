package com.petazone.user.dto.request;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CreateUserRequestDTO {
    @NotNull
    String userName;

    @NotNull
    String passwordHash;

    @NotNull
    String email;

    @NotNull
    String fullName;
}
