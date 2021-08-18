package com.hlx.posterm.controller;

import com.hlx.posterm.dto.Key;
import com.hlx.posterm.service.KeyGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/keyGen")
public class KeyGeneratorController {

    private KeyGeneratorService svc;

    @Autowired
    public KeyGeneratorController(KeyGeneratorService svcIn) {
        svc = svcIn;
    }

    @PostMapping
    public Key generateKey(@RequestBody Key keyIn) {
        Long privatePart = svc.generate(keyIn.getPublicPart());
        return new Key(keyIn.getPublicPart(),privatePart);
    }

}
