package com.it.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.pojo.Login;
import com.it.pojo.TestInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestInfoMapper extends BaseMapper<TestInfo> {
}
