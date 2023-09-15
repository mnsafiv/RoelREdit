package com.safonov_iv.roelredit.GenerateObject.Component;

import java.util.HashSet;
import java.util.Set;

public class BitmapConfig {
    private Set<String> keys;
    private String key;

    public BitmapConfig(String key) {
        this.key = key;
        keys=new HashSet<>();
    }

    public void addKey(String key){
        keys.add(key);
    }

    public String getKey() {
        return key;
    }

    public Set<String> getKeys() {
        return keys;
    }
}
