package com.mydeviceinfo.util;


public class StringUtils {
    
    public static boolean isNull(String s) {
        return s == null || s.trim().length() <= 0;
    }
    public static boolean isNotNull(String s) {
        return !isNull(s);
    }

}
