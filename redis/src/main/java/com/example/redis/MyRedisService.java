package com.example.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class MyRedisService {

    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public MyRedisService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void saveValue(String key, Object value) {
        // Chuyển về dạng byte array để truy xuất nhanh hơn, đặc biệt là những value dài
        byte[] valueBytes = value.toString().getBytes();
        redisTemplate.opsForValue().set(key, valueBytes);
    }

    public Object getValue(String key) {
        byte[] storedValueBytes = (byte[]) redisTemplate.opsForValue().get(key);
        assert storedValueBytes != null;
        return new String(storedValueBytes);
    }
    
    public boolean deleteValue(String key){
        return Boolean.TRUE.equals(redisTemplate.delete(key));
    }
}