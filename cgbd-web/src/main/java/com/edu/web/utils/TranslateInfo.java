package com.edu.web.utils;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class TranslateInfo {
    private List<LangDetail> langDetails;
    private MultipartFile importFile;
}
