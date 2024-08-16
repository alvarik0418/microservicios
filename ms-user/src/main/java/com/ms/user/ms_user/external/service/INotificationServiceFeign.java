package com.ms.user.ms_user.external.service;

import com.ms.user.ms_user.dto.EmailDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="NOTIFICATIONV2/v2/notification")
public interface INotificationServiceFeign {
    @PostMapping("/email")
    ResponseEntity<?> sendEmail(@RequestBody EmailDTO emailDTO);
}
