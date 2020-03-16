package com.edu.cgbd.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MarkdownData implements Serializable {
    private String tag;
    private String title;
    private String details;
    private String publishTime;
}
