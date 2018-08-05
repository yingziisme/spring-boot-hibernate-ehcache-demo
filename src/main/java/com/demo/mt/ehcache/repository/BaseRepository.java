package com.demo.mt.ehcache.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * BaseRepository
 *
 * @author MT.LUO
 * 2018/8/4 11:17
 * @Description: 所有repository的基类
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T>, Serializable {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update #{#entityName} t set t.deleted=1 where t.id = ?1")
    int setDeletedTrue(ID id);

}
