package com.hlx.posterm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hlx.posterm.dto.Key;
import com.hlx.posterm.dto.PostCodeInfo;
import com.hlx.posterm.service.KeyGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Locale;

@RestController
@RequestMapping("/keyGen")
public class KeyGeneratorController {

    private KeyGeneratorService svc;

    @Autowired
    public KeyGeneratorController(KeyGeneratorService svcIn) {
        svc = svcIn;
    }

    @PostMapping
    public Key generateKey(@RequestBody Key keyIn) throws JsonProcessingException {
        Long privatePart = svc.generate(keyIn.getPublicPart());
        Key returnKey = new Key(keyIn.getPublicPart(), privatePart);
        String uri = "http://127.0.0.1:8080/store/";
        WebClient client = WebClient.create();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(returnKey);
        WebClient.ResponseSpec resp = client.post()
                .uri(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(json)
                .retrieve();
        return resp.bodyToMono(Key.class).block();
    }

    @GetMapping("/{publicPartIn}")
    public Key getSecretPart(@PathVariable String publicPartIn) throws JsonProcessingException {
        String uri = "http://127.0.0.1:8080/store/" + publicPartIn;
        WebClient client = WebClient.create();
        WebClient.ResponseSpec resp = client.get()
                .uri(uri)
                .retrieve();
        return Key.builder()
                .publicPart(Integer.valueOf(publicPartIn))
                .privatePart(Long.valueOf(resp.bodyToMono(String.class).block()))
                .build();

    }
}
