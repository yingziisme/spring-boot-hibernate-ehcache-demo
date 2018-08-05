package com.demo.mt.ehcache.service;

import com.alibaba.fastjson.JSONObject;
import com.demo.mt.ehcache.repository.BaseRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * BaseService
 *
 * @author MT.LUO
 * 2018/7/9 11:21
 * @Description:
 */

public class BaseService<T, ID extends Serializable> {

    @Autowired
    protected BaseRepository<T, ID> baseRepository;


    public void save(T entity) {
        baseRepository.save(entity);
    }

    public void del(ID id) {
        baseRepository.deleteById(id);
    }

    public void setDeletedTrue(ID id) {
        baseRepository.setDeletedTrue(id);
    }

    public Optional<T> findOne(ID id) {
        return baseRepository.findById(id);
    }


    public List<T> findAll() {

        return baseRepository.findAll();
    }

    public Object search(JSONObject object) {
        return baseRepository.findAll();
    }


    public List<T> findAll(Specification<T> specification) {
        return baseRepository.findAll(specification);
    }

    public Page<T> findAll(Specification<T> specification, Pageable pageable) {
        return baseRepository.findAll(specification, pageable);
    }


}
