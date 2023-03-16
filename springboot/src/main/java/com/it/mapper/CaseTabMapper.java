package com.it.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.pojo.MyCaseTab;
import com.it.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CaseTabMapper extends BaseMapper<MyCaseTab> {
}
