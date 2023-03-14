package com.it.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.mapper.TestInfoMapper;
import com.it.pojo.SampleTestInfo;
import com.it.service.TestInfoService;
import org.springframework.stereotype.Service;

@Service
public class TestInfoServiceImpl extends ServiceImpl<TestInfoMapper, SampleTestInfo> implements TestInfoService {
}
