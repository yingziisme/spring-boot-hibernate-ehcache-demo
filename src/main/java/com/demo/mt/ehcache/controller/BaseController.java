package com.demo.mt.ehcache.controller;

import com.alibaba.fastjson.JSONObject;
import com.demo.mt.ehcache.entity.BaseEntity;
import com.demo.mt.ehcache.service.BaseService;
import com.demo.mt.ehcache.utils.ResultModel;
import com.github.wenhao.jpa.Specifications;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * BaseController
 *
 * @author MT.LUO
 * 2018/7/9 11:34
 * @Description:
 */
@Slf4j
@CacheConfig(cacheNames = "testCache")
public class BaseController<S extends BaseService<T, ID>, T extends BaseEntity<T, ID>, ID extends Serializable> {
    @Autowired
    protected S baseManager;

    @Autowired
    private MessageSource messageSource;

    @Cacheable(key = "#root.target + '_' + #p0 + '_' + #p1")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResultModel getList(@RequestParam int pageSize, @RequestParam int pageNumber) {
        log.info("BaseController list");
        Specification<T> specification = Specifications.<T>and().eq("deleted", false).build();

        if (pageSize > 0) {

            Pageable pageable = PageRequest.of(pageNumber, pageSize);
            Page<T> page = baseManager.findAll(specification, pageable);
            return ResultModel.ok(page);

        } else if (pageSize == -1) {
            return ResultModel.ok(baseManager.findAll());
        } else {
            List<T> entities = baseManager.findAll(specification);
            return ResultModel.ok(entities);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultModel findOne(@PathVariable ID id) {
        return ResultModel.ok(baseManager.findOne(id));
    }

    @RequestMapping(value = "/action", method = RequestMethod.POST)
    public ResultModel add(@Valid T entity, BindingResult result) {
        log.info("BaseController action post");
        if (result.hasErrors()) {
            System.out.println(entity.toString());
            return ResultModel.error(result, messageSource);
        }
        log.info(entity.toString());

        baseManager.save(entity);
        return ResultModel.ok();
    }

    @RequestMapping(value = "/action/{id}", method = RequestMethod.POST)
    public ResultModel update(@Valid T entity, BindingResult result, @PathVariable ID id) {
        log.info("BaseController action PUT");
        if (result.hasErrors()) {
            return ResultModel.error(result, messageSource);
        }
        log.info("BaseController entity{}", entity.toString());

        Optional<T> optional = baseManager.findOne(id);
        if (optional.isPresent()) {
            T old = optional.get();
            entity.setId(id);
            entity.setDeleted(old.isDeleted());
            baseManager.save(old);
        }
        return ResultModel.ok();

    }

    @RequestMapping(value = "/action/{id}", method = RequestMethod.DELETE)
    public ResultModel delete(@PathVariable ID id) {
        log.info("BaseController action DELETE");
        baseManager.setDeletedTrue(id);
        return ResultModel.ok();
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ResultModel search(@RequestBody JSONObject object) {
        System.out.println(object.toJSONString());
        log.info("BaseController search post:" + object.toString());
        return ResultModel.ok(baseManager.search(object));
    }

    //---------------------------------------------------------

}
