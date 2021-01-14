package com.redislabs.springredisbootstrap;

import org.springframework.beans.factory.annotation.Autowired;

public class RedisRepository implements DataRepository {

    @Autowired
    private RedisConfig redisConfig;

    @Override
    public String ping() {
        return null;
    }

    @Override
    public void loadData() {

    }
}
