package com.invest.redis;

import com.invest.pojo.User;
import org.apache.ibatis.cache.Cache;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static com.invest.redis.SerializeUtil.*;

public class RedisCache implements Cache {
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private String id;

    public RedisCache(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        this.id = id;

    }

    public String getId() {
        return this.id;
    }

    public void putObject(Object key, Object value) {
        redisUtil.getJedis().set(serialize(key.toString()),
                serialize(value));

    }

    public Object getObject(Object key) {
        Object value = unserialize(redisUtil.getJedis().get(
                serialize(key.toString())));
        return value;

    }

    public Object removeObject(Object key) {
        return redisUtil.getJedis().expire(
                serialize(key.toString()), 0);

    }

    public void clear() {
        redisUtil.getJedis().flushDB();
    }

    public int getSize() {
        return Integer.valueOf(redisUtil.getJedis().dbSize().toString());
    }

    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }


}

