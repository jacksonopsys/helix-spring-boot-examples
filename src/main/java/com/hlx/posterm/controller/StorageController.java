package com.hlx.posterm.controller;

import com.hlx.posterm.dto.Key;
import com.hlx.posterm.service.KeyStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store")
public class StorageController {
    KeyStorageService svc;

    @Autowired
    public StorageController(KeyStorageService svcIn) {
        svc = svcIn;
    }

    @PostMapping
    public Key storeNewPair(@RequestBody Key keyIn) {
        svc.save(keyIn.getPrivatePart(), keyIn);
        return keyIn;
    }

    @GetMapping("/{publicPartIn}")
    public Long readKeyFromPublicPart(@PathVariable String publicPartIn) {
        return svc.findByValue(Key.builder().publicPart(Integer.valueOf(publicPartIn)).build());
    }
}
