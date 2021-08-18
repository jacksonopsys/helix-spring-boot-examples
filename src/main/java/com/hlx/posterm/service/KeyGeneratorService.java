package com.hlx.posterm.service;

import org.springframework.stereotype.Service;

@Service
public class KeyGeneratorService {

    public Long generate(Integer publicIn) {
        return publicIn.longValue() * 10L;
    }

}
