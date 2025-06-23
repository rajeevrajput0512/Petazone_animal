package com.petazone.user.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KeyRequestDTO {

    @NotNull
    String value;

    Integer cd;

}
