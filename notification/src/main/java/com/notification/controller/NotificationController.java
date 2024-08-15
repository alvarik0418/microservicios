package com.notification.controller;

import com.notification.dto.EmailDTO;
import com.notification.services.INotificacionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/notification")
public class NotificationController {

    private final INotificacionService notificationService;

    @PostMapping
    public ResponseEntity<Boolean> sendEmail(@RequestBody EmailDTO email) {
        return notificationService.sendNotificacion(email);
    }
}
