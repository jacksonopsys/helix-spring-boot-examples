package com.hlx.posterm.service;

import java.util.HashMap;
import java.util.Map;

public class StorageService<K, V> {
    Map<K, V> map = new HashMap<>();

    public void save(K keyIn, V valueIn) {
        map.put(keyIn, valueIn);
    }

    public K findByValue(V valueIn) {
        for (Map.Entry<K, V> item : map.entrySet()) {
            if (item.getValue().equals(valueIn)) {
                return item.getKey();
            }
        }
        return null;
    }

    public V findByKey(K keyIn) {
        return map.get(keyIn);
    }

}
