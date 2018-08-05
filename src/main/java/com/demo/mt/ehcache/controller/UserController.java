package com.demo.mt.ehcache.controller;

import com.demo.mt.ehcache.entity.UserEntity;
import com.demo.mt.ehcache.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 *
 * @author MT.LUO
 * 2018/8/4 22:32
 * @Description:
 */
@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController<UserService, UserEntity, Long> {
}
