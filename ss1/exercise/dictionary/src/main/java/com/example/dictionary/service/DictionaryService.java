package com.example.dictionary.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryService {
    private static Map<String, String> map = new HashMap<>();

    static {
        map.put("apple", "Quả táo");
        map.put("banana", "Quả chuối");
        map.put("pig", "Con lợn");
        map.put("Book", "Quyển sách");
        map.put("pen", "Cây bút");
        map.put("map", "Bản đồ");
        map.put("flower", "Hoa");
        map.put("red", "Màu đỏ");
        map.put("blue", "Màu xanh");
        map.put("cat", "Con mèo");
        map.put("dog", "Con chó");
        map.put("kid", "Trẻ em");
    }

    public String lookUp(String english) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (english.toLowerCase().equals(entry.getKey())) {
                return map.get(entry.getKey());
            }
        }
        return english + " was not found in the dictionary !";
    }
}
