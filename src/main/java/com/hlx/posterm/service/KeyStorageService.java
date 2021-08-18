package com.hlx.posterm.service;

import com.hlx.posterm.dto.Key;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class KeyStorageService extends StorageService <Long,Key>{
    public Long findByValue(Key valueIn) {
        for (Map.Entry<Long, Key> item : map.entrySet()) {
            if (item.getValue().getPublicPart().equals(valueIn.getPublicPart())) {
                return item.getKey();
            }
        }
        return null;
    }
}
