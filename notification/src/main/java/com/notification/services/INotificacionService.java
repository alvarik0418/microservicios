package com.notification.services;

import com.notification.dto.EmailDTO;
import org.springframework.http.ResponseEntity;

public interface INotificacionService {
    public ResponseEntity<Boolean> sendNotificacion(EmailDTO email);
}
