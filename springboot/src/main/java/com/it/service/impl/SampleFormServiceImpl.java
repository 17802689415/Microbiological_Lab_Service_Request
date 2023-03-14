package com.it.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.mapper.SampleFormMapper;
import com.it.mapper.SampleTestInfoMapper;
import com.it.pojo.SampleForm;
import com.it.pojo.SampleTestInfo;
import com.it.service.SampleFormService;
import com.it.service.SampleTestInfoService;
import org.springframework.stereotype.Service;

@Service
public class SampleFormServiceImpl extends ServiceImpl<SampleFormMapper, SampleForm> implements SampleFormService {
}
