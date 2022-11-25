package com.capgemini;

import java.util.HashMap;
import java.util.Map;

public class RomanNumbersConverter {

    public static void main(String[] args) {
        Map<String, Long> romanInteger = new HashMap<>();
        romanInteger.put("I", 1L);
        romanInteger.put("IV", 4L);
        romanInteger.put("V", 5L);
        romanInteger.put("IX", 9L);
        romanInteger.put("X", 10L);
        romanInteger.put("XL", 40L);
        romanInteger.put("L", 50L);
        romanInteger.put("XC", 90L);
        romanInteger.put("C", 100L);
        romanInteger.put("CD", 400L);
        romanInteger.put("D", 500L);
        romanInteger.put("CM", 900L);
        romanInteger.put("M", 1000L);

        System.out.println(romanInteger.get("M"));
    }
}
