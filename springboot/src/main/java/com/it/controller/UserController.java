package com.it.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.it.pojo.Login;
import com.it.pojo.User;
import com.it.service.LoginService;
import com.it.service.UserService;
import com.it.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/lab")
public class UserController {
    @Autowired
    private CacheManager cacheManager;
    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;
    @Autowired
    RedisTemplate redisTemplate;

    @PostMapping("/login")
    @ResponseBody
//    @CachePut(value = "userCache",key = "#log.username")
    @Cacheable(value = "userCache",key = "#log.username")
    public R<Login> userManager(Login log){
        LambdaQueryWrapper<Login> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Login::getUsername,log.getUsername());
        Login one = loginService.getOne(queryWrapper);
        if (one!=null&one.getPassword().equals(log.getPassword())){
            return R.success(one);
        }
        return R.error("登录失败");
    }
}
