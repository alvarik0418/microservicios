package com.notification.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmailDTO {

    @NotBlank
    @NotEmpty
    @Size(min = 5, max = 50)
    private String to;

    @NotBlank
    @NotEmpty
    @Size(min = 1, max = 50)
    private String subject;

    @NotBlank
    @NotEmpty
    @Size(max = 5000)
    private String body;
}
