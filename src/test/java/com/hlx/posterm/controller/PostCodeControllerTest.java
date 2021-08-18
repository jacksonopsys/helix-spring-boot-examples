package com.hlx.posterm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hlx.posterm.dto.PostCodeInfo;
import com.hlx.posterm.dto.ValidationStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PostCodeControllerTest {
    private WebClient client;

    @BeforeEach
    public void setUp() {
        client = WebClient.create();
    }

    @Test
    public void canValidateUSPostcode() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        PostCodeInfo info = new PostCodeInfo(Locale.US,"12345");
        String json = null;
        json = mapper.writeValueAsString(info);
        String uri = "http://127.0.0.1:8084/address";
        WebClient.ResponseSpec resp = client.post()
                                        .uri(uri)
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(json)
                                        .retrieve();
        ValidationStatus responseStatus = resp.bodyToMono(ValidationStatus.class).block();
        assertEquals("valid",responseStatus.getStatus());
        assertEquals("en_US post code", responseStatus.getMessage());
    }
}
