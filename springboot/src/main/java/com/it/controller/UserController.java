package com.it.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.it.pojo.Login;
import com.it.pojo.TestInfo;
import com.it.pojo.User;
import com.it.service.LoginService;
import com.it.service.TestInfoService;
import com.it.service.UserService;
import com.it.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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
    private TestInfoService testInfoService;
    @Autowired
    RedisTemplate redisTemplate;

    public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z" };

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

    @GetMapping("/getNo")
    @ResponseBody
    public R<String> getNo(){
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString();
        uuid=uuid.replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 62]);
        }
        return R.success(shortBuffer.toString());
    }

    @PostMapping("/postTestInfo")
    @ResponseBody
    public R<String> postTestInfo(TestInfo testInfo){
        if (testInfo.getQuantity()>testInfo.getLimitValue()){
            return R.error("超出接收限值");
        }
        LambdaQueryWrapper<TestInfo> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(TestInfo::getApplyNum,testInfo.getApplyNum());
        double sum = 0;
        for (TestInfo info : testInfoService.list(queryWrapper)) {
            sum+=info.getQuantity();
        }

        boolean save = testInfoService.save(testInfo);
        if (save){
            redisTemplate.opsForValue().set(testInfo.getId(),testInfo.toString());
            return R.success("success");
        }
        return R.error("error");
    }
}
