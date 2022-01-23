package com.mmutawe.projects.school.library.be.configs;

import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class CacheConfiguration {

    CacheManagerCustomizer<ConcurrentMapCacheManager> cacheManagerCustomizer(){
        return new ConcurrentCustomizer();
    }

//    @Component
    class ConcurrentCustomizer implements CacheManagerCustomizer<ConcurrentMapCacheManager> {

        @Override
        public void customize(ConcurrentMapCacheManager cacheManager) {
            cacheManager.setAllowNullValues(false);
            cacheManager.setStoreByValue(false);
        }
    }

}
