package com.bancolombia.notificationV2.controller;

import com.bancolombia.notificationV2.dto.EmailDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/v2/notification")
public class NotificationController {

    @PostMapping("/email")
    public ResponseEntity<?> sendEmail(@RequestBody EmailDTO email) {
        return ResponseEntity.ok(true);
    }
}
