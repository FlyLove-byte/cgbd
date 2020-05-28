package com.edu.web.service.searchService.impl;

import com.edu.cgbd.pojo.CgbdResult;
import com.edu.cgbd.pojo.MarkdownData;
import com.edu.web.client.SearchServiceClient;
import com.edu.web.service.searchService.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    SearchServiceClient searchServiceClient;

    @Override
    public CgbdResult contentCommit(MarkdownData markdownData) {
        return searchServiceClient.contentCommit(markdownData);
    }
}
