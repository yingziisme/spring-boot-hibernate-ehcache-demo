package com.demo.mt.ehcache.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * RoleEntity
 *
 * @author MT.LUO
 * 2018/8/4 22:11
 * @Description:
 */
@Data
@Entity
@Table(name = "role_tb")
@EqualsAndHashCode(callSuper = false)
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "entityCache")
public class RoleEntity extends BaseEntity<RoleEntity, Long> {

    protected String roleName;
}
