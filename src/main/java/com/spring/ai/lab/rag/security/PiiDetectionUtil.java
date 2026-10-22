package com.spring.ai.lab.rag.security;

import java.util.regex.Pattern;

public class PiiDetectionUtil {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}");

    private static final Pattern PHONE_PATTERN = Pattern.compile("(\\+\\d{1,3}[- ]?)?\\d{10}");

    public static boolean containsPii(String text) {
        if(text == null) return false;

        return EMAIL_PATTERN.matcher(text).find() ||  PHONE_PATTERN.matcher(text).find();
    }

}
