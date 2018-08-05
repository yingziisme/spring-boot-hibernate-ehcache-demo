package com.demo.mt.ehcache.controller;

import com.demo.mt.ehcache.entity.RoleEntity;
import com.demo.mt.ehcache.service.RoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RoleController
 *
 * @author MT.LUO
 * 2018/8/4 22:34
 * @Description:
 */
@RestController
@RequestMapping(value = "/role")
public class RoleController extends BaseController<RoleService, RoleEntity, Long>{
}
