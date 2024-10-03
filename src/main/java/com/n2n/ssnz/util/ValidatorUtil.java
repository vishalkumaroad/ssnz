package com.n2n.ssnz.util;

import java.util.Map;

public class ValidatorUtil {

    public static boolean isEmpty(String source) {
        return source == null || source.trim().length() == 0;
    }

    public static boolean isNumberPositive(int number) {
        return number > 0;
    }

    public static boolean isEmpty(Map source) {
        return source == null || source.isEmpty();
    }
}
