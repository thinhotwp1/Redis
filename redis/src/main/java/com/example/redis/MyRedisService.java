package com.example.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class MyRedisService {

    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public MyRedisService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public boolean saveValue(String key, Object value) {
        redisTemplate.opsForValue().set(key, value,30, TimeUnit.SECONDS);
        // lưu cache vào redis trong 30 giây, sau 30 giây tự xóa, ở đây lưu giây để dễ test, thực tế thì có thể để theo nhu cầu
        return getValue(key).toString().equals(value.toString());
    }

    public Object getValue(String key) {
        byte[] storedValueBytes = (byte[]) redisTemplate.opsForValue().get(key);
        // assert storedValueBytes != null; là một câu lệnh kiểm tra (assertion) trong Java để kiểm tra
        // một điều kiện và đảm bảo rằng nó phải là đúng (true). Nếu điều kiện kiểm tra trả về giá trị sai
        // (false), một AssertionError sẽ được ném ra và chương trình sẽ dừng lại.
        assert storedValueBytes != null;
        return new String(storedValueBytes);
    }
    
    public boolean deleteValue(String key){
        return Boolean.TRUE.equals(redisTemplate.delete(key));
    }
}