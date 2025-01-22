package com.example.Url_Shortener.utils;

public class HashUrl {
    private static final String DICTIONARY = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String hashToBase62(long id) {
        if (id == 0) return "0";
        StringBuilder hash = new StringBuilder();
        while (id != 0) {
            int remainder = (int) (id % 62);
            hash.insert(0, DICTIONARY.charAt(remainder));
            id = id / 62;
        }
        return hash.toString();
    }
}
