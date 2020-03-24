package com.edu.cgbd.utils;

import java.util.UUID;

public class FormatUtil {
    public static String getUUID (){
        return String.valueOf(UUID.randomUUID()).replace("-", "");
    }
}
