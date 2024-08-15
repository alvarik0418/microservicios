package com.ms.user.ms_user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @NotBlank
    @NotEmpty
    @Size(min = 2, max = 10)
    @Pattern(regexp = "^(?:CC|CE)$", message = "El tipo de documento debe ser CC o CE")
    private String typeDocument;

    @NotBlank
    @NotEmpty
    @Size(min = 6, max = 10, message = "El rango no es válido")
    @Pattern(regexp = "^[0-9]*$", message = "Sólo se permite números")
    private String document;

    @NotBlank
    @NotEmpty
    @Size(min = 3, max = 20)
    private String username;
}
