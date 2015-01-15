package com.mrkid.service;

import com.mrkid.entity.Pojo;
import org.perf4j.aop.Profiled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mrkid.repository.PojoRepository;

/**
 * User: xudong
 * Date: 12/2/14
 * Time: 3:29 PM
 */
@Service
public class PojoService {
    private static Logger logger = LoggerFactory.getLogger(PojoService.class);

    @Autowired
    private PojoRepository pojoRepository;

    @Transactional
    @Profiled(tag = "savePojo")
    public void save(Pojo pojo) {
        logger.debug("save pojo {}", pojo);
        pojoRepository.save(pojo);
    }

    @Transactional
    @Profiled(tag = "deletePojo")
    public void delete(Pojo pojo) {
        logger.debug("delete pojo {}", pojo);
        pojoRepository.delete(pojo);
    }

    @Transactional(readOnly = true)
    @Profiled(tag = "getPojo")
    public Pojo get(Long id) {
        return pojoRepository.findOne(id);
    }

}
