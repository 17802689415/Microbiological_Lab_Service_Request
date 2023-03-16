package com.it.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.mapper.CaseTabMapper;
import com.it.mapper.UserMapper;
import com.it.pojo.MyCaseTab;
import com.it.pojo.User;
import com.it.service.CaseTabService;
import com.it.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class CaseTabServiceImpl extends ServiceImpl<CaseTabMapper, MyCaseTab> implements CaseTabService {
}
