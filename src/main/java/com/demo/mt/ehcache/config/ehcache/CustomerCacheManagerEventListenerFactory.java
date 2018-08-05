package com.demo.mt.ehcache.config.ehcache;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.event.CacheManagerEventListener;
import net.sf.ehcache.event.CacheManagerEventListenerFactory;

import java.util.Properties;

public class CustomerCacheManagerEventListenerFactory extends CacheManagerEventListenerFactory {

    @Override
    public CacheManagerEventListener createCacheManagerEventListener(CacheManager cacheManager, Properties properties) {
        return new CustomerCacheManagerEventListener(cacheManager);
    }
}
