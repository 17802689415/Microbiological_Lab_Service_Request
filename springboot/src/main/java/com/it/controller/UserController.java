package com.it.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.pojo.*;
import com.it.service.*;
import com.it.utils.MyUserDetailsService;
import com.it.utils.PageCommon;
import com.it.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
//@CrossOrigin
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
    private SampleTestInfoService testInfoService;

    @Autowired
    private SampleFormService sampleFormService;

    @Autowired
    private ConsignorFormService consignorFormService;
    @Autowired
    private CaseTabService caseTabService;
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    private MyUserDetailsService myUserDetailsService;
    public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z" };

    @PostMapping("/login")
    @ResponseBody
//    @CachePut(value = "userCache",key = "#log.username")
//    @Cacheable(value = "userCache",key = "#log.username")
    public R<UserDetails> userManager(Login log){
//        LambdaQueryWrapper<Login> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(Login::getUsername,log.getUsername());
//        Login one = loginService.getOne(queryWrapper);
//        if (one!=null&one.getPassword().equals(log.getPassword())){
//            return R.success(one);
//        }
//        UserDetails userDetails = myUserDetailsService.loadUserByUsername(log.getUsername());
//        System.out.println(userDetails==null);
//        if (userDetails!=null){
//            return R.success(userDetails);
//        }


        return loginService.login(log);
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

    @PostMapping("/postSampleTestInfo")
    @ResponseBody
    public R<String> postSampleTestInfo(@RequestBody List<SampleTestInfo> testInfo){
        for (SampleTestInfo s: testInfo) {
            System.out.println(s);
            if (s.getQuantity()>s.getLimitValue()){
                return R.error("超出接收限值");
            }
            boolean save = testInfoService.save(s);
            if (!save){
                return R.error("error");

            }
        }
        return R.success("success");
    }

    @PostMapping("/postSampleInfo")
    @ResponseBody
    public R<String> postSampleInfo(SampleForm sampleForm){
        boolean save = sampleFormService.save(sampleForm);
        if (save){
            return R.success("success");
        }
        return R.success("error");
    }
    @PostMapping("/postConsignorInfo")
    @ResponseBody
    public R<String> postConsignorInfo(ConsignorForm consignorForm){
        boolean save = consignorFormService.save(consignorForm);
        if (save){
            return R.success("success");
        }
        return R.error("error");
    }

    @PostMapping("/postCase")
    @ResponseBody
    public R<String> postCase(MyCaseTab myCaseTab){
        boolean save = caseTabService.save(myCaseTab);
        if (save){
            return R.success("success");
        }
        return R.error("error");
    }

    @PostMapping("/selectCase")
    @ResponseBody
    public R<Page> selectCase(PageCommon pageCommon){
        //分页构造器
        Page pageInfo = new Page(pageCommon.getPage(),pageCommon.getPageSize());

        LambdaQueryWrapper<MyCaseTab> queryWrapper =new LambdaQueryWrapper<>();
        queryWrapper.orderByAsc(MyCaseTab::getSendDate);
        caseTabService.page(pageInfo,queryWrapper);
        return R.success(pageInfo);
    }

    @PostMapping("/selectUrgentCase")
    @ResponseBody
    public R<List<SampleTestInfo>> selectUrgentCase(){
        List<SampleTestInfo> list =new ArrayList<>();
        LambdaQueryWrapper<ConsignorForm> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ConsignorForm::isUrgent,true);
        for (ConsignorForm consignorForm : consignorFormService.list(queryWrapper)) {
            LambdaQueryWrapper<SampleTestInfo> queryWrapper1 =new LambdaQueryWrapper<>();
            queryWrapper1.eq(SampleTestInfo::getApplyNum,consignorForm.getApplyNum());
            for (SampleTestInfo sampleTestInfo : testInfoService.list(queryWrapper1)) {
                boolean add = list.add(sampleTestInfo);
                if (!add){
                    return R.error("error");
                }
            }

        }

        return R.success(list);
    }
}
