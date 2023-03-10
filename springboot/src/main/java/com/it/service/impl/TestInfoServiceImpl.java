package com.it.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.mapper.LoginMapper;
import com.it.mapper.TestInfoMapper;
import com.it.pojo.Login;
import com.it.pojo.TestInfo;
import com.it.service.LoginService;
import com.it.service.TestInfoService;
import org.springframework.stereotype.Service;

@Service
public class TestInfoServiceImpl extends ServiceImpl<TestInfoMapper, TestInfo> implements TestInfoService {
}
