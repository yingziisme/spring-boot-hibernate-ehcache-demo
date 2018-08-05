package com.demo.mt.ehcache.config.ehcache;

import net.sf.ehcache.event.CacheEventListener;
import net.sf.ehcache.event.CacheEventListenerFactory;

import java.util.Properties;


public class CustomerCacheEventListenerFactory extends CacheEventListenerFactory {
    @Override
    public CacheEventListener createCacheEventListener(Properties properties) {
        return new CustomerCacheEventListener();
    }
}
