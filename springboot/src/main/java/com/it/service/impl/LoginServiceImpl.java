package com.it.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.mapper.LoginMapper;
import com.it.mapper.UserMapper;
import com.it.pojo.Login;
import com.it.pojo.User;
import com.it.service.LoginService;
import com.it.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, Login> implements LoginService {
}
