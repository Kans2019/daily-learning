package com.study.august.effective.servicetest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: Services
 * @date: 2020/8/1
 * @author: likanghai
 */
public class Services {

    private static final Logger LOGGER = LoggerFactory.getLogger(Services.class);

    private Services(){

    }

    private static final Map<String, Provider> PROVIDERS = new ConcurrentHashMap<String, Provider>();

    public static final String DEFAULT_PROVIDER_NAME = "<def>";

    public static void registerDefaultProvider(Provider p){
        registerProvider(DEFAULT_PROVIDER_NAME, p);
    }

    public static void registerProvider(String name, Provider p){
        PROVIDERS.put(name, p);
    }

    public static Service newInstance(){
        return newInstance(DEFAULT_PROVIDER_NAME);
    }


    public static Service newInstance(String name){
        Provider p = PROVIDERS.get(name);
        if(p == null){
            LOGGER.error( "No provider registered with name");
            return null;
        }
        return p.newService();
    }
}
