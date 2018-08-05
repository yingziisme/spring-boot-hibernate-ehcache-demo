package com.demo.mt.ehcache.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * UserEntity
 *
 * @author MT.LUO
 * 2018/8/4 22:10
 * @Description:
 */
@Data
@Entity
@Table(name = "user_tb")
@EqualsAndHashCode(callSuper = false)
public class UserEntity extends BaseEntity<UserEntity, Long> {
    protected String userName;

}
