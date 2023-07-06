package com.example.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    MyRedisService redisService;

    @GetMapping("/save-key")
    public void saveKeyValue(){
        redisService.saveValue("key_sercert","123456");
    }

    @GetMapping("/get-key")
    public String getString(){
        return redisService.getValue("key_sercert").toString();
    }

    @GetMapping("/delete-key")
    public boolean deleteKeyValue(){
       return redisService.deleteValue("key_sercert");
    }
}
