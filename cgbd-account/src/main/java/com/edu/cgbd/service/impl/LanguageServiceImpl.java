package com.edu.cgbd.service.impl;

import com.edu.cgbd.domain.account.LangDetail;
import com.edu.cgbd.mapper.LangDetailMapper;
import com.edu.cgbd.service.LanguageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@CacheConfig(cacheNames = "language")
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    LangDetailMapper langDetailMapper;

    // region 查询语言包
    @Override
    @Cacheable(key = "#root.methodName")
    public List<LangDetail> langDetails() {
        return langDetailMapper.selectAll();
    }
    // endregion
}
