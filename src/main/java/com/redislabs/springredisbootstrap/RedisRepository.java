package com.redislabs.springredisbootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ClusterOperations;
import org.springframework.data.redis.core.RedisTemplate;

import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class RedisRepository implements DataRepository {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    private ValueOperations valueOperations;

    @Autowired
    public RedisRepository(RedisTemplate<String, Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init(){
        valueOperations = redisTemplate.opsForValue();
    }

    @Override
    public String ping() {
        return "pong";
    }

    @Override
    public String loadData() {
        System.out.println("loading data from Redis!");
        String res = (String) valueOperations.get("mykey");
        System.out.println(String.format("data: %s", res));
        return res;
    }

    @Override
    public String setData(String data) {
        System.out.println("setting data in Redis!");
        valueOperations.set(data, data);
        return String.format("set %s", data);
    }
}
