package com.it.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.mapper.LoginMapper;
import com.it.mapper.UserMapper;
import com.it.pojo.Login;
import com.it.pojo.User;
import com.it.service.LoginService;
import com.it.service.UserService;
import com.it.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, Login> implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Override
    public R<UserDetails> login(Login log) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(log.getUsername(), log.getPassword(), new ArrayList<>()));
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("error");
        }
        return null;
    }
}
