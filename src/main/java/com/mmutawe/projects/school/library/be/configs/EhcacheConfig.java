//package com.mmutawe.projects.school.library.be.configs;
//
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.ehcache.EhCacheCacheManager;
//import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//
//@Configuration
//public class EhcacheConfig {
//
//    @Bean
//    public CacheManager cacheManager() {
//        return new EhCacheCacheManager(ehCacheCacheManager().getObject());
//    }
//
//    public EhCacheManagerFactoryBean ehCacheCacheManager() {
//        EhCacheManagerFactoryBean factory = new EhCacheManagerFactoryBean();
//        factory.setConfigLocation(new ClassPathResource("ehcache.xml"));
//        factory.setShared(true);
//        return factory;
//    }
//}
