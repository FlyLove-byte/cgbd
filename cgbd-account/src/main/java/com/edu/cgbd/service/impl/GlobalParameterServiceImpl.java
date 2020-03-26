package com.edu.cgbd.service.impl;

import com.edu.cgbd.domain.account.GlobalParameterExample;
import com.edu.cgbd.mapper.GlobalParameterMapper;
import com.edu.cgbd.service.GlobalParameterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@CacheConfig(cacheNames = "globalParameter")
public class GlobalParameterServiceImpl implements GlobalParameterService {

    @Autowired
    GlobalParameterMapper globalParameterMapper;

    @Override
    @Cacheable(key = "'globalParameter'.concat('-').concat(#p0)")
    public String globalParameterByKey(String key) {
        return globalParameterMapper.selectByPrimaryKey(key).getParamValue();
    }
}
