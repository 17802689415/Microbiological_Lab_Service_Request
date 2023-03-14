package com.it.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.mapper.ConsignorFormMapper;
import com.it.mapper.SampleFormMapper;
import com.it.pojo.ConsignorForm;
import com.it.pojo.SampleForm;
import com.it.service.ConsignorFormService;
import com.it.service.SampleFormService;
import org.springframework.stereotype.Service;

@Service
public class ConsignorFormServiceImpl extends ServiceImpl<ConsignorFormMapper, ConsignorForm> implements ConsignorFormService {
}
