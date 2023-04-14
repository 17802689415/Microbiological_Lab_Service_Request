package com.it.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.it.pojo.ApplyForm;
import com.it.pojo.ConsignorInfo;
import com.it.pojo.InspectorTaskInfo;
import com.it.pojo.SampleTestInfo;
import com.it.service.ApplyFormService;
import com.it.service.ConsignorInfoService;
import com.it.service.InspectorTaskInfoService;
import com.it.service.SampleTestInfoService;
import com.it.utils.OptionCommon;
import com.it.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
//@CrossOrigin
@RestController
@RequestMapping("/lab")
public class SelectCaseController {

    @Autowired
    private ApplyFormService applyFormService;

    @Autowired
    private InspectorTaskInfoService inspectorTaskInfoService;

    @Autowired
    private SampleTestInfoService sampleTestInfoService;

    @Autowired
    private ConsignorInfoService consignorInfoService;

    @PostMapping("/selectUrgentCase")
    @ResponseBody
    public R<List<ApplyForm>> selectUrgentCase(){

        LambdaQueryWrapper<ApplyForm> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ApplyForm::isUrgent,true);
        List<ApplyForm> list = applyFormService.list(queryWrapper);
        return R.success(list,1);

    }

    @PostMapping("/selectWaitCase")
    @ResponseBody
    public R<List<InspectorTaskInfo>> selectWaitCase(){

        LambdaQueryWrapper<InspectorTaskInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(InspectorTaskInfo::getStatus,"待检测");
        List<InspectorTaskInfo> list = inspectorTaskInfoService.list(queryWrapper);
        return R.success(list,1);
    }

    @PostMapping("/selectItem")
    @ResponseBody
    public R<List<SampleTestInfo>> selectItem(String caseNum){

        LambdaQueryWrapper<SampleTestInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SampleTestInfo::getCaseNum,caseNum);
        List<SampleTestInfo> list = sampleTestInfoService.list(queryWrapper);
        return R.success(list,1);
    }


    @PostMapping("/selectMyCaseBy")
    @ResponseBody
    public R<List<ApplyForm>> selectMyCaseBy(OptionCommon optionCommon){

        LambdaQueryWrapper<ApplyForm> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.and(i -> i.eq(ApplyForm::getTestType,optionCommon.getTypeValue()).eq(ApplyForm::getStatus,optionCommon.getStatusValue()));
        List<ApplyForm> list = applyFormService.list(queryWrapper);
        return R.success(list,1);
    }

    @PostMapping("/selectConsignor")
    @ResponseBody
    public R<List<ConsignorInfo>> selectConsignor(String caseNum){

        LambdaQueryWrapper<ConsignorInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ConsignorInfo::getCaseNum,caseNum);
        List<ConsignorInfo> list = consignorInfoService.list(queryWrapper);
        return R.success(list,1);
    }
}
