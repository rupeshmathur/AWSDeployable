package com.cloud.AWSDeployable.AWSDeployable.service;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class WhatsAppService {

    private static final String TOKEN = "YOUR_ACCESS_TOKEN";
    private static final String PHONE_NUMBER_ID = "YOUR_PHONE_NUMBER_ID";

    public void sendWhatsAppMessage(String toNumber, String message) {
        String url = "https://graph.facebook.com/v20.0/" + PHONE_NUMBER_ID + "/messages";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(TOKEN);

        Map<String, Object> body = Map.of(
                "messaging_product", "whatsapp",
                "to", toNumber,
                "type", "text",
                "text", Map.of("body", message)
        );

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        System.out.println("Response: " + response.getBody());
    }
}
