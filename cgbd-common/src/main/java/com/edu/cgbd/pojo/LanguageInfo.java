package com.edu.cgbd.pojo;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class LanguageInfo {
    List<String> langs;
    Map<Object, Map<Object,Object>> langDetails;
}
