package com.example.springbootexersicemain.service;

import com.example.springbootexersicemain.event.BookNotFoundEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class SmsService {

    @Value("${sms.endpoint}")
    private String endpoint;

    @Value("${sms.phoneNumber}")
    private String phoneNumber;

    @Async
    @EventListener
    public void sendSms(BookNotFoundEvent event) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        try {
            JSONObject jsonObject = new JSONObject()
                    .put("serviceName", "Spring Boot Exercise Main")
                    .put("message", "Book not found: " + event.getBookTitle())
                    .put("to", phoneNumber);

            HttpEntity<String> request = new HttpEntity<>(jsonObject.toString(), headers);
            new RestTemplate().postForObject(endpoint, request, Object.class);

        } catch (Exception e) {
            log.error("Error sending SMS", e);
        }
    }

}
