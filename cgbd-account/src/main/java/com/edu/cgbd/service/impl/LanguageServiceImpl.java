package com.edu.cgbd.service.impl;

import com.edu.cgbd.domain.account.LangDetail;
import com.edu.cgbd.mapper.LangDetailMapper;
import com.edu.cgbd.service.LanguageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@CacheConfig(cacheNames = "language")
/*@Caching(cacheable = @Cacheable, evict = { @CacheEvict })*/
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    LangDetailMapper langDetailMapper;

    // region 查询语言包
    @Override
    @Cacheable(key = "methodName")
    public List<LangDetail> langs() {
        return langDetailMapper.selectAll();
    }
    // endregion
}
