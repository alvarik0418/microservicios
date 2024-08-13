package com.ms.user.ms_user.controller;

import com.ms.user.ms_user.model.UserEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name="User Controller", description = "API exposed for CRUD operations on users")
public interface IUserDoc {
    @Operation(summary = "Create user", description = "This operation is for creating user")
    @ApiResponses(value =
            {
                @ApiResponse(
                        responseCode = "201",
                        description = "User created",
                        content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)

                ),
                @ApiResponse(
                        responseCode = "500",
                        description = "Error Server",
                        content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
                ),
                @ApiResponse(
                        responseCode = "400",
                        description = "Not Found",
                        content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
                )
            }
    )
    ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user);
}
