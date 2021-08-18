package com.hlx.posterm.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalLong;

@Service
public class StorageService<K,V> {
    Map<K,V> map = new HashMap<>();

    public void save(K keyIn, V valueIn) {
        map.put(keyIn,valueIn);
    }

    public K findByKey(V valueIn) {
        for(Map.Entry<K,V> item: map.entrySet()) {
            if(item.getValue().equals(valueIn)) {
                return item.getKey();
            }
        }
        return null;
    }

    public V findByValue(K keyin) {
        return map.get(keyin);
    }

}
