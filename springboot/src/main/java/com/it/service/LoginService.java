package com.it.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.it.pojo.Login;
import com.it.pojo.User;
import com.it.utils.R;
import org.springframework.security.core.userdetails.UserDetails;

public interface LoginService extends IService<Login> {
    R<UserDetails> login(Login log);
}
