package com.it.controller;

import com.it.pojo.ApplyForm;
import com.it.pojo.ConsignorInfo;
import com.it.pojo.SampleInfo;
import com.it.pojo.SampleTestInfo;
import com.it.service.ApplyFormService;
import com.it.service.ConsignorInfoService;
import com.it.service.SampleInfoService;
import com.it.service.SampleTestInfoService;
import com.it.utils.R;
import com.it.utils.RedisCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static com.it.controller.UserController.chars;

@Slf4j
//@CrossOrigin
@RestController
@RequestMapping("/lab")
public class PostCaseController {
    @Autowired
    private SampleTestInfoService testInfoService;

    @Autowired
    private SampleInfoService sampleFormService;

    @Autowired
    private ConsignorInfoService consignorFormService;
    @Autowired
    private ApplyFormService applyFormService;

    @Autowired
    private RedisCache redisCache;

    @GetMapping("/getNo")
    @PreAuthorize("hasAuthority('ROLE_admin')")
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
        return R.success(shortBuffer.toString(),1);
    }

    @PostMapping("/postSampleTestInfo")
    @ResponseBody
    public R<String> postSampleTestInfo(@RequestBody List<SampleTestInfo> testInfo){
        for (SampleTestInfo s: testInfo) {
            System.out.println(s);
            if (s.getQuantity()>s.getLimitValue()){
                return R.error("超出接收限值",0);
            }
            boolean save = testInfoService.save(s);
            if (!save){
                return R.error("error",0);

            }
        }
        return R.success("success",1);
    }

    @PostMapping("/postSampleInfo")
    @ResponseBody
    public R<String> postSampleInfo(SampleInfo sampleForm){
        boolean save = sampleFormService.save(sampleForm);
        if (save){
            return R.success("success",1);
        }
        return R.error("error",0);
    }
    @PostMapping("/postConsignorInfo")
    @ResponseBody
    public R<String> postConsignorInfo(ConsignorInfo consignorForm){
        boolean save = consignorFormService.save(consignorForm);
        if (save){
            return R.success("success",1);
        }
        return R.error("error",0);
    }

    @PostMapping("/postCase")
    @ResponseBody
    public R<String> postCase(ApplyForm applyForm){
        boolean save = applyFormService.save(applyForm);
        if (save){
            return R.success("success",1);
        }
        return R.error("error",0);
    }
}
