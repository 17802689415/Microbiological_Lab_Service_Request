package com.it.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.pojo.*;
import com.it.service.*;
import com.it.utils.PageCommon;
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

    @Autowired
    private UserInfoService userInfoService;

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
    public R<Page> selectMyCaseBy(PageCommon pageCommon){
        Page pageInfo = new Page(pageCommon.getPage(),pageCommon.getPageSize());
        List list = new ArrayList();

        LambdaQueryWrapper<UserInfo> queryWrapper =new LambdaQueryWrapper<>();
        queryWrapper.eq(UserInfo::getUsername,pageCommon.getUsername());
        UserInfo one = userInfoService.getOne(queryWrapper);

        LambdaQueryWrapper<ConsignorInfo> queryWrapper1 =new LambdaQueryWrapper<>();
        queryWrapper1.eq(ConsignorInfo::getJobId,one.getJobId());

        Page page = consignorInfoService.page(pageInfo, queryWrapper1);
        System.out.println(page.getRecords());
        for (ConsignorInfo consignorInfo : consignorInfoService.list(queryWrapper1)) {
            MyCaseCommon myCaseCommon = new MyCaseCommon();
            myCaseCommon.setCaseNum(consignorInfo.getCaseNum());
            myCaseCommon.setJobId(consignorInfo.getJobId());
            LambdaQueryWrapper<ApplyForm> queryWrapper2 = new LambdaQueryWrapper<>();
            queryWrapper2.and(i -> i.like(ApplyForm::getTestType,pageCommon.getTypeValue()).like(ApplyForm::getStatus,pageCommon.getStatusValue()).eq(ApplyForm::getCaseNum,consignorInfo.getCaseNum()));
            for (ApplyForm applyForm : applyFormService.list(queryWrapper2)) {
                myCaseCommon.setStatus(applyForm.getStatus());
                myCaseCommon.setTestType(applyForm.getTestType());
                list.add(myCaseCommon);
            }
        }
        page.setRecords(list);
        return R.success(page,1);
    }

    @PostMapping("/selectMyCase")
    @ResponseBody
    public R<Page> selectMyCase(PageCommon pageCommon){

        System.out.println(pageCommon);
        Page pageInfo = new Page(pageCommon.getPage(),pageCommon.getPageSize());
        List list = new ArrayList();

        LambdaQueryWrapper<UserInfo> queryWrapper =new LambdaQueryWrapper<>();
        queryWrapper.eq(UserInfo::getUsername,pageCommon.getUsername());
        UserInfo one = userInfoService.getOne(queryWrapper);

        LambdaQueryWrapper<ConsignorInfo> queryWrapper1 =new LambdaQueryWrapper<>();
        queryWrapper1.eq(ConsignorInfo::getJobId,one.getJobId());

        Page page = consignorInfoService.page(pageInfo, queryWrapper1);
        System.out.println(page.getRecords());
        for (ConsignorInfo consignorInfo : consignorInfoService.list(queryWrapper1)) {
            MyCaseCommon myCaseCommon = new MyCaseCommon();
            myCaseCommon.setCaseNum(consignorInfo.getCaseNum());
            myCaseCommon.setJobId(consignorInfo.getJobId());
            LambdaQueryWrapper<ApplyForm> queryWrapper2 = new LambdaQueryWrapper<>();
            queryWrapper2.eq(ApplyForm::getCaseNum,consignorInfo.getCaseNum());
            for (ApplyForm applyForm : applyFormService.list(queryWrapper2)) {
                myCaseCommon.setStatus(applyForm.getStatus());
                myCaseCommon.setTestType(applyForm.getTestType());
                list.add(myCaseCommon);
            }
        }
        page.setRecords(list);
        return R.success(page,1);
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
